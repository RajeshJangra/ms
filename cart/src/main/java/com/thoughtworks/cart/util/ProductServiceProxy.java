package com.thoughtworks.cart.util;


import com.thoughtworks.cart.dto.InventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name = "product-service", url = "http://product-service", fallback = ProductServiceFallback.class)
@Component
public interface ProductServiceProxy {

  @RequestMapping(value = "/inventory/product/{productId}", method = GET)
  InventoryDto getProductById(@PathVariable long productId);
}
