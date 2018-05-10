package com.thoughtworks.product.service;

import com.thoughtworks.product.entity.Inventory;
import com.thoughtworks.product.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import static java.lang.String.format;

@Service
public class InventoryService {

  @Autowired
  private InventoryRepository repository;

  @Autowired
  private ProductService productService;

  @Value("${max.inventory}")
  private int maxInventory;

  public Inventory getInventoryByProductId(long productId) {
    return repository.findInventoryByProduct(productService.getProductById(productId))
      .orElseThrow(() -> new EntityNotFoundException(format("Inventory does not exist for Product: %d", productId)));
  }

  public Inventory getInventoryById(long id) {
    return repository
      .findById(id)
      .orElseThrow(() -> new EntityNotFoundException(format("Inventory: %d does not exist", id)));
  }

  public Iterable<Inventory> getAllInventory() {
    return repository.findAll();
  }

  public Inventory createInventory(Inventory inventory) {
    final long productId = inventory.getProduct().getId();
    if (repository.findInventoryByProduct(productService.getProductById(productId)).isPresent()) {
      throw new EntityExistsException(format("Inventory already exists for Product: %d", productId));
    }
    validateInventory(inventory);
    return repository.save(inventory);
  }

  public Inventory updateInventory(Inventory inventory) {
    Inventory savedInventory = getInventoryById(inventory.getId());
    savedInventory.update(inventory);
    validateInventory(savedInventory);
    return repository.save(savedInventory);
  }

  public String deleteInventory(int id) {
    repository.delete(getInventoryById(id));
    return format("Inventory: %d Successfully deleted", id);
  }

  private void validateInventory(final Inventory inventory) {
    final long inventoryCount = inventory.getCount();
    if (inventoryCount > maxInventory) {
      throw new RuntimeException(format("Inventory count: %d is greater than max inventory count: %d", inventoryCount, maxInventory));
    }
  }
}
