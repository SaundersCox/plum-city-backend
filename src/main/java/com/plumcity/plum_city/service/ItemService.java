package com.plumcity.plum_city.service;

import com.plumcity.plum_city.config.AppConfig;
import com.plumcity.plum_city.dto.ItemRequestDto;
import com.plumcity.plum_city.dto.ItemResponseDto;
import com.plumcity.plum_city.entity.Item;
import com.plumcity.plum_city.mapper.ItemMapper;
import com.plumcity.plum_city.repository.ItemRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

  private final ItemRepository itemRepository;
  private final ItemMapper itemMapper;
  private final AppConfig customConfig;

  /**
   * Retrieves Items with pagination and sorting.
   *
   * @param pageable pagination and sorting
   * @return page of items
   */
  @Transactional(readOnly = true)
  public Page<ItemResponseDto> getItems(Pageable pageable) {
    Page<Item> itemPage = itemRepository.findAll(pageable);
    return itemPage.map(itemMapper::toDto);
  }

  /**
   * Creates a new Item based on the request.
   *
   * @param itemRequestDto The Item as a request
   * @return The created Item as a response
   */
  public ItemResponseDto createItem(ItemRequestDto itemRequestDto) {
    Item item = itemMapper.toEntity(itemRequestDto);
    Item savedItem = itemRepository.save(item);
    return itemMapper.toDto(savedItem);
  }



  public Optional<Item> getItemById(UUID id) {
    return itemRepository.findById(id);
  }

  public boolean deleteItem(UUID id) {
    if (itemRepository.existsById(id)) {
      itemRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
