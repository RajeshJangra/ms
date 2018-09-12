package com.thoughtworks.gw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@RestController
public class GwApplication {

  public static void main(String[] args) {
    SpringApplication.run(GwApplication.class, args);
  }

//  @Bean
//  public SimpleFilter simpleFilter() {
//    return new SimpleFilter();
//  }

  @RequestMapping(method = RequestMethod.GET, value = "/hello")
  public String findById() {
    return "Hello World!";
  }
}
