package com.masala.indianSpices.products.controller;

import com.masala.indianSpices.Dto.Product;
import com.masala.indianSpices.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsControllerImpl implements ProductsController {

    @Autowired
    private ProductService productService;

    @Override
    public List<Product> fetchProducts() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setCanExchange(true);
        product.setAvailableQuantity(5);
        product.setCanReturn(false);
        product.setEta(3);
        product.setId(25);
        product.setName("Jeera");
        products.add(product);
        Product product1 = new Product();
        product1.setCanExchange(true);
        product1.setAvailableQuantity(2);
        product1.setCanReturn(false);
        product1.setEta(4);
        product1.setId(26);
        product1.setName("Chilli");
        products.add(product1);
        return products;
    }

    @Override
    public List<Product> fetchSerchedProducts(String name) {
        return null;
    }

    @Override
    public String setProductsOnEs() throws IOException {
        return productService.setProductEsData();
    }
}
