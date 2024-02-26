package com.chandooiitm.springbootDockercompose.service;

import com.chandooiitm.springbootDockercompose.entity.Product;
import com.chandooiitm.springbootDockercompose.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product data) {
        return productRepository.save(data);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).get();
        //Add object mapping here using mapstruc dependency
        Product updatedProduct = productRepository.save(existingProduct);
        return updatedProduct;
    }

    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "data removed !! " + id;
    }

}