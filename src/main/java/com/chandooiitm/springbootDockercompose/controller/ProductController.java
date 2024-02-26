package com.chandooiitm.springbootDockercompose.controller;

import com.chandooiitm.springbootDockercompose.entity.Product;
import com.chandooiitm.springbootDockercompose.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    // build create Product REST API
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // build get product by id REST API
    // http://localhost:8080/api/products/1
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId) {
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Build Get All Products REST API
    // http://localhost:8080/api/products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Build Update Product REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/products/1
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId,
                                                 @RequestBody Product product) {
        product.setId(productId);
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // Build Delete Product REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product successfully deleted!", HttpStatus.OK);
    }
}