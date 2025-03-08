package com.plumcity.plum_city.controller;


import com.plumcity.plum_city.dto.ItemRequestDto;
import com.plumcity.plum_city.dto.ItemResponseDto;
import com.plumcity.plum_city.service.ItemSearchCriteria;
import com.plumcity.plum_city.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@Tag(name = "Items", description = "Items are the core part of the retail business.")
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemService;

  @GetMapping
  @Operation(summary = "Get items", description = "Retrieves items based on search criteria with pagination")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully retrieved items")})
  public ResponseEntity<Page<ItemResponseDto>> getItems(
      @Parameter(description = "Search criteria") ItemSearchCriteria criteria,
      @Parameter(description = "Pagination parameters") Pageable pageable) {
    Page<ItemResponseDto> items = itemService.getItems(pageable);
    return ResponseEntity.ok(items);
  }

  @PostMapping
  public ResponseEntity<ItemResponseDto> createItem(
      @Valid @RequestBody ItemRequestDto itemRequestDto) {
    // TODO
    return ResponseEntity.ok(itemService.createItem(itemRequestDto));
  }

}
