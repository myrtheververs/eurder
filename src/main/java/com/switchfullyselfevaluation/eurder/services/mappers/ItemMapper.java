package com.switchfullyselfevaluation.eurder.services.mappers;

import com.switchfullyselfevaluation.eurder.domain.Item;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item toItem(CreateItemDTO createItemDTO) {
        Item item = new Item(createItemDTO.getName(), createItemDTO.getDescription(), createItemDTO.getPrice(), createItemDTO.getAmount());
        return item;
    }

}
