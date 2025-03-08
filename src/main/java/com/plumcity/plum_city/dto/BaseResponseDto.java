package com.plumcity.plum_city.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Base class for all Response DTOs that contain database managed fields that users may want to
 * retrieve. There is no DTO validation since validation occurs at both the Entity and Database
 * layers.
 */
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
public abstract class BaseResponseDto {

  private UUID id;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
