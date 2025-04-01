package com.plumcity.plum_city.mapper;

import com.plumcity.plum_city.dto.ItemResponseDto;
import com.plumcity.plum_city.dto.ItemRequestDto;
import com.plumcity.plum_city.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

  ItemResponseDto toDto(Item item);

  Item toEntity(ItemRequestDto itemRequestDto);
}

