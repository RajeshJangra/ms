package com.thoughtworks.cart.util;

import com.thoughtworks.cart.dto.InventoryDto;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceFallback implements ProductServiceProxy {
  @Override
  public InventoryDto getProductById(long productId) {
    String message = "\nProduct Service is down or product: " + productId + " not available\n";
    System.out.println(message);
    throw new RuntimeException(message);
  }
}
