package com.plumcity.plum_city.service;

import com.plumcity.plum_city.entity.Item;
import com.plumcity.plum_city.repository.ItemRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

  private final ItemRepository itemRepository;

  public Item createItem(Item item) {
    return itemRepository.save(item);
  }

  public List<Item> getAllItems() {
    return itemRepository.findAll();
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
