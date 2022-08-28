package com.api.store.service;

import com.api.store.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    Product getProductBySKU(String sku);
    Product updateProduct(Product product, String sku);
    void deleteProduct(String sku);
}
