package com.thoughtworks.product.controller;

import com.thoughtworks.product.entity.Product;
import com.thoughtworks.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

  @Autowired
  private ProductService service;

  @GetMapping(value = "/{id}")
  ResponseEntity<Product> getProductById(@PathVariable long id) {
    return new ResponseEntity<>(service.getProductById(id), OK);
  }

  @GetMapping
  ResponseEntity<Iterable<Product>> getAllProducts() {
    return new ResponseEntity<>(service.getAllProducts(), OK);
  }

  @PostMapping()
  ResponseEntity<Product> createProduct(@RequestBody Product product) {
    return new ResponseEntity<>(service.createProduct(product), OK);
  }

  @PutMapping
  ResponseEntity<Product> updateProduct(@RequestBody Product product) {
    return new ResponseEntity<>(service.updateProduct(product), OK);
  }

  @DeleteMapping(value = "/{id}")
  ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
    return new ResponseEntity<>(service.deleteProduct(id), OK);
  }
}
