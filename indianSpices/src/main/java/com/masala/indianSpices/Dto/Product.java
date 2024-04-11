package com.masala.indianSpices.Dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer Id;
    @Column(name = "name")
    public String name;
    @Column(name = "available_quantity")
    public Integer availableQuantity;
    @Column(name = "can_return")
    public Boolean canReturn;
    @Column(name = "can_exchange")
    public Boolean canExchange;
    @Column(name = "eta")
    public Integer eta;

}
