package com.switchfullyselfevaluation.eurder.service.mapper;

import com.switchfullyselfevaluation.eurder.domain.item.Item;

import com.switchfullyselfevaluation.eurder.service.dto.CreateItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    //STORY 2: add item
    public Item toEntity(CreateItemDto createItemDto) {
        return new Item(
                createItemDto.getName(),
                createItemDto.getDescription(),
                createItemDto.getPrice(),
                createItemDto.getAmountInStock()
        );
    }


}
