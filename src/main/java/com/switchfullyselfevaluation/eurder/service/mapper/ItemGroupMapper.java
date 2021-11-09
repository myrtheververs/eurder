package com.switchfullyselfevaluation.eurder.service.mapper;

import com.switchfullyselfevaluation.eurder.domain.itemgroup.ItemGroup;

import com.switchfullyselfevaluation.eurder.service.ItemService;
import com.switchfullyselfevaluation.eurder.service.dto.CreateItemGroupDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ItemGroupMapper {

    private final ItemService itemService;

    public ItemGroupMapper(ItemService itemService) {
        this.itemService = itemService;
    }

    public ItemGroup toEntity(CreateItemGroupDto createItemGroupDto) {
        LocalDate shippingDate = LocalDate.now().plusDays(1);   // not correct yet
        return new ItemGroup(itemService.getItemById(createItemGroupDto.getItemId()), createItemGroupDto.getAmountToOrder());
    }
}
