package com.thoughtworks.product.controller;

import com.thoughtworks.product.entity.Inventory;
import com.thoughtworks.product.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

  @Autowired
  private InventoryService service;

  @GetMapping(value = "/{id}")
  ResponseEntity<Inventory> getInventoryById(@PathVariable long id) {
    return new ResponseEntity<>(service.getInventoryById(id), OK);
  }

  @GetMapping(value = "/product/{productId}")
  ResponseEntity<Inventory> getInventoryByProductId(@PathVariable Long productId) {
    System.out.println("\nproductId = " + productId);
    return new ResponseEntity<>(service.getInventoryByProductId(productId), OK);
  }

  @GetMapping
  ResponseEntity<Iterable<Inventory>> getAllInventory() {
    return new ResponseEntity<>(service.getAllInventory(), OK);
  }

  @PostMapping()
  ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
    return new ResponseEntity<>(service.createInventory(inventory), OK);
  }

  @PutMapping
  ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory) {
    return new ResponseEntity<>(service.updateInventory(inventory), OK);
  }

  @DeleteMapping(value = "/{id}")
  ResponseEntity<String> deleteInventory(@PathVariable Integer id) {
    return new ResponseEntity<>(service.deleteInventory(id), OK);
  }
}
