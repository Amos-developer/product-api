package com.example.productapi.Service.ServiceImplementation;

import com.example.productapi.Entity.Product;
import com.example.productapi.Repository.ProductRepository;
import com.example.productapi.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductImplementation implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id).orElseThrow(
                ()-> new RuntimeException('Product not found')
        );
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = repository.findById().orElseThrow(()
        -> RuntimeException('Product not found'));

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());

        return repository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        return repository.deleteById(id);
    }
}
