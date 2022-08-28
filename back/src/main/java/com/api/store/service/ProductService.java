package com.api.store.service;

import com.api.store.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    Product getProductById(long id);
    Product updateProduct(Product product, long id);
    void deleteProduct(long id);
}
