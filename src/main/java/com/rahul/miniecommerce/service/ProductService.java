package com.rahul.miniecommerce.service;

import com.rahul.miniecommerce.model.Product;
import com.rahul.miniecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 🔹 Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 🔹 Get product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // 🔹 Add or update product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // 🔹 Delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
