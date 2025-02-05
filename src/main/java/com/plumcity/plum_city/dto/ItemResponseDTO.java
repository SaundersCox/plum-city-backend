package com.plumcity.plum_city.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ItemResponseDTO {

  private UUID id;
  private Double price;
  private String name;
  private String description;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
