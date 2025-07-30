package com.example.productapi.Contoller;
import com.example.productapi.Entity.Product;
import com.example.productapi.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product create(@RequestBody Product product){
        return (Product) productService.createProduct(product);
    }

    @GetMapping("/read")
    public List<Product> getAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/read/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
