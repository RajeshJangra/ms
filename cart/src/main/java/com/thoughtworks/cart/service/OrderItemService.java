package com.thoughtworks.cart.service;

import com.thoughtworks.cart.entity.OrderItem;
import com.thoughtworks.cart.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderItemService {

  @Autowired
  private OrderItemRepository repository;

  @Transactional
  public OrderItem createOrderItem(OrderItem orderItem) {
    return repository.save(orderItem);
  }
}
