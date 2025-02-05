package com.plumcity.plum_city.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ItemRequestDTO {

  private String name;
  private String description;
  private Double price;
}
