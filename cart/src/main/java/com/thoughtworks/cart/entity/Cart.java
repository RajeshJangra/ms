package com.thoughtworks.cart.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@ApiModel(value = "Cart", description = "Cart resource representation")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "CART")
public class Cart {
  @ApiModelProperty(value = "Cart's id", required = true)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private long id;

  @OneToMany(
    mappedBy = "cart",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  @JsonManagedReference
  private Set<OrderItem> orderItems;

  public long getId() {
    return id;
  }

  public Set<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(final Set<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Cart cart = (Cart) o;
    return id == cart.id;
  }

  @Override
  public int hashCode() {

    return Objects.hash(id);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Cart{");
    sb.append("id=").append(id);
    sb.append(", orderItems=").append(orderItems);
    sb.append('}');
    return sb.toString();
  }
}
