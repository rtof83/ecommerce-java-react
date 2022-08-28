package com.api.store.service.impl;

import com.api.store.exception.ResourceNotFoundException;
import com.api.store.model.Product;
import com.api.store.repository.ProductRepository;
import com.api.store.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductBySKU(String sku) {
        Optional<Product> product = productRepository.findById(sku);

        return productRepository.findById(sku).orElseThrow(() ->
                new ResourceNotFoundException("Product", "sku", sku));
    }

    @Override
    public Product updateProduct(Product product, String sku) {

        // check if product exist
        Product existProduct = productRepository.findById(sku).orElseThrow(() ->
                new ResourceNotFoundException("Product", "sku", sku));

//        existProduct.setSku(product.getSku());
        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        existProduct.setQuantity(product.getQuantity());
        existProduct.setDescr(product.getDescr());
        existProduct.setImage(product.getImage());

        // save product to DB
        productRepository.save(existProduct);
        return existProduct;
    }

    @Override
    public void deleteProduct(String sku) {

        // check if product exist
        Product existProduct = productRepository.findById(sku).orElseThrow(() ->
                new ResourceNotFoundException("Product", "sku", sku));

        productRepository.deleteById(sku);
    }
}
