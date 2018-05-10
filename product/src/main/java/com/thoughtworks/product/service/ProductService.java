package com.thoughtworks.product.service;

import com.thoughtworks.product.entity.Product;
import com.thoughtworks.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import static java.lang.String.format;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public Product getProductById(long id) {
    return repository
      .findById(id)
      .orElseThrow(() -> new EntityNotFoundException(format("Product: %d does not exist", id)));
  }

  public Iterable<Product> getAllProducts() {
    return repository.findAll();
  }

  public Product createProduct(Product Product) {
    return repository.save(Product);
  }

  public Product updateProduct(Product product) {
    Product savedProduct = getProductById(product.getId());
    savedProduct.update(product);
    return repository.save(savedProduct);
  }

  public String deleteProduct(int id) {
    repository.delete(getProductById(id));
    return format("Product: %d Successfully deleted", id);
  }
}
