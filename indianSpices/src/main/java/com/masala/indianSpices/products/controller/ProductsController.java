package com.masala.indianSpices.products.controller;

import com.masala.indianSpices.Dto.Product;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
public interface ProductsController {
    @GetMapping("/")
    public List<Product> fetchProducts();

    @GetMapping("/{name}")
    public List<Product> fetchSerchedProducts(@RequestParam("name") String name);

    @PostMapping("/setProducts/es")
    public String setProductsOnEs() throws IOException;
}
