package com.thoughtworks.cart.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestUtil {

  @Autowired
  private RestTemplate restTemplate;

  public <T> T get(final String url, Class<T> clazz) {
    return restTemplate.getForObject(url, clazz);
  }
}
