package com.thoughtworks.product.repository;

import com.thoughtworks.product.entity.Inventory;
import com.thoughtworks.product.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
  public Optional<Inventory> findInventoryByProduct(Product product);
}
