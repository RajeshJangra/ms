package com.thoughtworks.cart.dto;

import java.io.Serializable;
import java.util.Objects;

public class InventoryDto implements Serializable {
  private long id;

  private long count = 0;

  private Product product;

  public long getId() {
    return id;
  }

  public Product getProduct() {
    return product;
  }

  public long getCount() {
    return count;
  }

  public InventoryDto setProduct(final Product product) {
    this.product = product;
    return this;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final InventoryDto inventoryDto = (InventoryDto) o;
    return id == inventoryDto.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Inventory{");
    sb.append("id=").append(id);
    sb.append(", product=").append(product);
    sb.append(", count=").append(count);
    sb.append('}');
    return sb.toString();
  }
}
