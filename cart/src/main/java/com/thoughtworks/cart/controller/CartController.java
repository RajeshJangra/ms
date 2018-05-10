package com.thoughtworks.cart.controller;

import com.thoughtworks.cart.entity.Cart;
import com.thoughtworks.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/carts")
@RefreshScope
public class CartController {

  @Autowired
  private CartService service;

  @GetMapping(value = "/{id}")
  ResponseEntity<Cart> getCartById(@PathVariable long id) {
    return new ResponseEntity<>(service.getCartById(id), OK);
  }

  @GetMapping
  ResponseEntity<Iterable<Cart>> getAllCarts() {
    return new ResponseEntity<>(service.getAllCarts(), OK);
  }

  @PostMapping()
  ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
    System.out.println("\ncart = " + cart);
    return new ResponseEntity<>(service.createCart(cart), OK);
  }

  @PutMapping
  ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
    return new ResponseEntity<>(service.updateCart(cart), OK);
  }

  @DeleteMapping(value = "/{id}")
  ResponseEntity<String> deleteCart(@PathVariable Integer id) {
    return new ResponseEntity<>(service.deleteCart(id), OK);
  }
}
