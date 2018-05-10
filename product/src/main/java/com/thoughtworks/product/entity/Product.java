package com.thoughtworks.product.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@ApiModel(value = "Product", description = "Product resource representation")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "PRODUCT")
public class Product {
  @ApiModelProperty(value = "Product's id", required = true)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private long id;
  @ApiModelProperty(value = "Product's name", required = true)
  @Size(max = 100)
  @Column(nullable = false)
  private String name;
  @ApiModelProperty(value = "Product's description", required = true)
  @Size(max = 300)
  @Column(nullable = false)
  private String description;

  public Product() {
  }

  public Product(@Size(max = 100) final String name, @Size(max = 300) final String description) {
    this.name = name;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }


  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Product product = (Product) o;
    return id == product.id &&
      Objects.equals(name, product.name) &&
      Objects.equals(description, product.description);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Product{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append('}');
    return sb.toString();
  }

  public Product update(final Product product) {
    this.name = product.name;
    this.description = product.description;
    return this;
  }
}
