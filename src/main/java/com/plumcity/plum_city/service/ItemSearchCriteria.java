package com.plumcity.plum_city.service;

import lombok.Data;

@Data
public class ItemSearchCriteria {
  private String name;
  private Double price;
  private String description;
  private String createdAt;
  private String updatedAt;
}
