package com.switchfullyselfevaluation.eurder.services.dtos;

import com.switchfullyselfevaluation.eurder.domain.Price;

import java.util.List;

public class OrderDTO {

    private final String uuid;
    private final List<ItemGroupDTO> itemGroupDTOS;
    private final Price totalPrice;

    public OrderDTO(String uuid, List<ItemGroupDTO> itemGroupDTOS, Price totalPrice) {
        this.uuid = uuid;
        this.itemGroupDTOS = itemGroupDTOS;
        this.totalPrice = totalPrice;
    }

    public String getUuid() {
        return uuid;
    }

    public List<ItemGroupDTO> getItemGroupDTOS() {
        return itemGroupDTOS;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }
}

