package com.masala.indianSpices.Dto;

import lombok.Data;

@Data
public class Product {

    public Integer Id;
    public String name;
    public Integer availableQuantity;
    public Boolean canReturn;
    public Boolean canExchange;
    public Integer eta;

}
