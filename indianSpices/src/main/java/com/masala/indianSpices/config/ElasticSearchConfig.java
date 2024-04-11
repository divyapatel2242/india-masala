package com.masala.indianSpices.config;

import com.amazonaws.services.cloudfront.util.SignerUtils;
import nl.altindag.ssl.SSLFactory;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.util.StringUtils;

@Configuration
@EnableReactiveElasticsearchRepositories(basePackages = {"com.masala.indianSpices.elasticSearchRepository"})
@ComponentScan(basePackages = {"com.masala.indianSpices"})
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Value("elasticsearch.url")
    private String elasticSearchUrl;

    SSLFactory sSlFactory = SSLFactory.builder().withUnsafeTrustMaterial().build();

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost("localhost",9200, SignerUtils.Protocol.http.toString()))
                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setSSLContext(sSlFactory.getSslContext()).setSSLHostnameVerifier(sSlFactory.getHostnameVerifier())).setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultRequestConfig(
                        RequestConfig.custom().setSocketTimeout(90000).setConnectTimeout(90000).setConnectionRequestTimeout(90000).build()
                ));
//        final ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo("http://localhost:9200/").withSocketTimeout(60000).build();
//        return RestClients.create(clientConfiguration).rest();
        RestHighLevelClient client = new RestHighLevelClient(restClientBuilder);
        return client;
    }
}
