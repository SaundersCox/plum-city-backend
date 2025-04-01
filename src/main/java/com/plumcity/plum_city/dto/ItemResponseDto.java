package com.plumcity.plum_city.dto;

import com.plumcity.plum_city.dto.api.ApiResponseDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ItemResponseDto extends ApiResponseDto {

  private Double price;
  private String name;
  private String description;

}
