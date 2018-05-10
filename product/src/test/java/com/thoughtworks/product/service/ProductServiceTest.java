package com.thoughtworks.product.service;

import com.thoughtworks.product.entity.Product;
import com.thoughtworks.product.repository.ProductRepository;
import name.falgout.jeffrey.testing.junit5.MockitoExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@DisplayName("Product Service Unit tests")
class ProductServiceTest {

  @InjectMocks
  private ProductService service;
  @Mock
  private ProductRepository repository;

  @Test
  @DisplayName("should get product by id")
  public void shouldGetProductById() {
    long productId = 1L;
    Product product = new Product();
    given(repository.findById(productId)).willReturn(Optional.of(product));

    assertEquals(product, service.getProductById(productId));
  }

  @Test
  @DisplayName("should throw exception if product not found for input id")
  void getCategoryByIdException() {
    long productId = 1L;
    given(repository.findById(productId)).willReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.getProductById(1L));
  }
}