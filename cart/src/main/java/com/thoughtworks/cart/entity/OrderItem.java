package com.thoughtworks.cart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

@ApiModel(value = "Order Item", description = "Order Item resource representation")
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {
  @ApiModelProperty(value = "Order Items's id", required = true)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private long id;

  @Column(nullable = false)
  private long count;

  @Column(nullable = false)
  private long productId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cart_id", nullable = false)
  @JsonBackReference
  private Cart cart;

  public long getId() {
    return id;
  }

  public long getCount() {
    return count;
  }

  public long getProductId() {
    return productId;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(final Cart cart) {
    this.cart = cart;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("OrderItem{");
    sb.append("id=").append(id);
    sb.append(", count=").append(count);
    sb.append(", productId=").append(productId);
    sb.append('}');
    return sb.toString();
  }
}
