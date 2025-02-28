package com.plumcity.plum_city.controller;

import com.plumcity.plum_city.dto.ItemRequestDto;
import com.plumcity.plum_city.dto.ItemResponseDto;
import com.plumcity.plum_city.service.ItemService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemService;

  @GetMapping
  public ResponseEntity<List<ItemResponseDto>> getAllItems() {
    return ResponseEntity.ok(itemService.getAllItems());
  }

  @PostMapping
  public ResponseEntity<ItemResponseDto> createItem(
      @Valid @RequestBody ItemRequestDto itemRequestDto) {
    // TODO
    //    return ResponseEntity.ok(itemService.createItem(itemRequestDto));
  }
}
