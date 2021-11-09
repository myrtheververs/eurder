package com.switchfullyselfevaluation.eurder.service.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.switchfullyselfevaluation.eurder.domain.Price;

import java.util.List;

public class OrderDto {

    private final String id;
    private final List<ItemGroupDto> itemGroupDtos;
    private final Price totalPrice;

    @JsonCreator
    public OrderDto(String id, List<ItemGroupDto> itemGroupDtos, Price totalPrice) {
        this.id = id;
        this.itemGroupDtos = itemGroupDtos;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public List<ItemGroupDto> getItemGroupDtos() {
        return itemGroupDtos;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }
}
