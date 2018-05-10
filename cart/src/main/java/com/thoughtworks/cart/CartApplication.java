package com.thoughtworks.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CartApplication {

  public static void main(String[] args) {
    SpringApplication.run(CartApplication.class, args);
  }
}
