package com.thoughtworks.product;

import com.thoughtworks.product.entity.Product;
import com.thoughtworks.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Product application tests")
public class ProductApplicationTests {

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private ProductService productService;

  @Test
  @DisplayName("should return application status as up")
  public void contextLoads() {
  }

  @Test
  @DisplayName("should return product by input id")
  public void getProductById() {
    Product product = new Product("Product", "Product Description");
    final Product savedProduct = productService.createProduct(product);

    ResponseEntity<Product> response = this.restTemplate.exchange("/products/" + savedProduct.getId(),
      HttpMethod.GET,
      null,
      Product.class);

    assertEquals(savedProduct, response.getBody());
  }

}
