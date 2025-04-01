package com.plumcity.plum_city.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ItemRequestDto {

  @NotNull
  private String name;

  @NotNull
  private String description;

  @NotNull(message = "Price is required")
  @DecimalMin(value = "0.00", inclusive = false, message = "Price must be greater than zero")
  @Digits(integer = 6, fraction = 2, message = "Price must have up to 10 digits and 2 decimal places")
  private Double price;
}
