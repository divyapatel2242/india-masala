package com.masala.indianSpices.products.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ProductService {
    public String setProductEsData() throws IOException;
}
