package com.plumcity.plum_city.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item extends BaseEntity {

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Double price;

  private String description;
}