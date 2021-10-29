package com.switchfullyselfevaluation.eurder.services.mappers;

import com.switchfullyselfevaluation.eurder.domain.Item;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateItemDTO;
import com.switchfullyselfevaluation.eurder.services.dtos.ItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

 /*   public Item toItem(ItemDTO itemDTO) {
        return new Item(itemDTO.getName(), itemDTO.getDescription(), itemDTO.getPrice());
    }*/


    public ItemDTO toItemDTO(Item item) {
        return new ItemDTO().setUuid(item.getUuid())
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setPrice(item.getPrice());
    }


}
