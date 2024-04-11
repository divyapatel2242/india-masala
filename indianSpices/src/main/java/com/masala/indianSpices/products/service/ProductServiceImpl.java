package com.masala.indianSpices.products.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.masala.indianSpices.Dto.ProductEs;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private RestHighLevelClient client;

    @Override
    public String setProductEsData() throws IOException {
        List<ProductEs> productEs = new ArrayList<>(Arrays.asList(new ProductEs(1,"Jira"),new ProductEs(2,"Chilli")));
        BulkRequest bulkRequest = new BulkRequest();
        for (ProductEs productEs1 : productEs){
            String jsonData = new ObjectMapper().writeValueAsString(productEs1);
            IndexRequest indexRequest = new IndexRequest("products");
            indexRequest.id(productEs1.getId().toString());
            indexRequest.source(jsonData, XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        int count = response.getItems().length;
        return "Successfully Added Data into ES "+ count;
    }
}
