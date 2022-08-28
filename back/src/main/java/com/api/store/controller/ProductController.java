package com.api.store.controller;

import com.api.store.model.Product;
import com.api.store.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    // build get all customers
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
