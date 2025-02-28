package com.plumcity.plum_city.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ItemResponseDto extends BaseResponseDto {

  private Double price;
  private String name;
  private String description;

}
