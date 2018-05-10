package com.thoughtworks.product.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@ApiModel(value = "Inventory", description = "Inventory resource representation")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "INVENTORY")
public class Inventory {
  @ApiModelProperty(value = "Inventory's id", required = true)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private long id;

  @ApiModelProperty(value = "Product's inventory count", required = true)
  @Column(nullable = false)
  private long count = 0;

  @OneToOne
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

  public Inventory setProduct(final Product product) {
    this.product = product;
    return this;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Inventory inventory = (Inventory) o;
    return id == inventory.id;
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

  public Inventory update(final Inventory inventory) {
    this.count = inventory.count;
    return this;
  }
}
