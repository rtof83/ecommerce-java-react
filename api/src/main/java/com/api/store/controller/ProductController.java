package com.api.store.controller;

import com.api.store.model.Product;
import com.api.store.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    // build create product
    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    // build get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // build get product by sku
    @GetMapping("{sku}")
    public ResponseEntity<Product> getProductBySKU(@PathVariable("sku") String sku) {
        return new ResponseEntity<Product>(productService.getProductBySKU(sku), HttpStatus.OK);
    }

    //build update product
    @PutMapping("{sku}")
    public ResponseEntity<Product> updateProduct(@PathVariable("sku") String sku, @RequestBody Product product) {
        return new ResponseEntity<Product>(productService.updateProduct(product, sku), HttpStatus.OK);
    }

    // build delete customer
    @DeleteMapping("{sku}")
    public ResponseEntity<String> deleteProduct(@PathVariable("sku") String sku) {
        productService.deleteProduct(sku);
        return new ResponseEntity<String>("Product deleted successfully", HttpStatus.NO_CONTENT);
    }
}
