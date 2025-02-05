package com.plumcity.plum_city.mapper;

import com.plumcity.plum_city.dto.ItemRequestDTO;
import com.plumcity.plum_city.dto.ItemResponseDTO;
import com.plumcity.plum_city.entity.Item;
import java.util.List;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {

  @Mapping(target = "id", source = "id")
  @Mapping(target = "price", source = "price")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "description", source = "description")
  ItemResponseDTO toItemResponseDTO(Item item);

  @Mapping(target = "name", source = "name")
  @Mapping(target = "price", source = "price")
  @Mapping(target = "description", source = "description")
  Item toItem(ItemRequestDTO itemRequestDTO);

  List<ItemResponseDTO> toItemResponseDTOList(List<Item> items);
}

