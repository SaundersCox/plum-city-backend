package com.plumcity.plum_city.controller;


import com.plumcity.plum_city.dto.ItemRequestDto;
import com.plumcity.plum_city.dto.ItemResponseDto;
import com.plumcity.plum_city.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@Tag(name = "Items", description = "Items are the core part of the retail business.")
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemService;

  @Operation(summary = "Get items", description = "Retrieves items based on search criteria with pagination")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully retrieved items")})
  @GetMapping
  public ResponseEntity<Page<ItemResponseDto>> getItems(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(defaultValue = "name") String sortField,
      @RequestParam(defaultValue = "ASC") String sortDirection)
  {
    Page<ItemResponseDto> items = itemService.getItems(page, size, sortField, sortDirection);
    return ResponseEntity.ok(items);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ItemResponseDto> getItemById(@PathVariable UUID id) {
    ItemResponseDto item = itemService.getItemById(id);
    return ResponseEntity.ok(item);
  }

  @PostMapping
  public ResponseEntity<ItemResponseDto> createItem(
      @Valid @RequestBody ItemRequestDto itemRequestDto) {
    // TODO
    return ResponseEntity.ok(itemService.createItem(itemRequestDto));
  }

}
