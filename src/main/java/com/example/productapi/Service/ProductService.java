package com.example.productapi.Service;

import com.example.productapi.Entity.Product;

import java.util.List;

public interface ProductService {
    ProductService createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
