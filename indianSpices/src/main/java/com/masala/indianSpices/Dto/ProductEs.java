package com.masala.indianSpices.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

//@Document(indexName = "products")
@Data
@AllArgsConstructor
//@Setting(settingPath = "setting.json")
public class ProductEs {
    @Id
//    @Field(type = FieldType.Keyword)
    private Integer id;
//    @Field(type = FieldType.Text)
    private String name;

}
