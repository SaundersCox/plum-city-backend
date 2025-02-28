package com.plumcity.plum_city.mapper;

import com.plumcity.plum_city.dto.ItemRequestDto;
import com.plumcity.plum_city.dto.ItemResponseDto;
import com.plumcity.plum_city.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {

  ItemResponseDto toDto(Item item);

  @Mapping(target = "name", source = "name")
  @Mapping(target = "price", source = "price")
  @Mapping(target = "description", source = "description")
  Item toEntity(ItemRequestDto itemRequestDTO);
}

