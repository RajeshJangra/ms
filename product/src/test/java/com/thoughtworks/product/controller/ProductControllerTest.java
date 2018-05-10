package com.thoughtworks.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.product.entity.Product;
import com.thoughtworks.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ProductController.class, secure = false)
@DisplayName("Product Controller tests")
class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProductService service;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  @DisplayName("should fetch a product by Id")
  void testFetchProductById() throws Exception {
    long productId = 1L;
    Product product = new Product();

    given(service.getProductById(productId)).willReturn(product);

    mockMvc
      .perform(get("/products/" + productId)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().json(objectMapper.writeValueAsString(product)));
  }

}