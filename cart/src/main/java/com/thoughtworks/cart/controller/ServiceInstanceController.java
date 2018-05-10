package com.thoughtworks.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/instances")
public class ServiceInstanceController {

  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping("/{applicationName}")
  public List<ServiceInstance> getInstanceByName(@PathVariable String applicationName) {
    return this.discoveryClient.getInstances(applicationName);
  }
}
