package com.switchfullyselfevaluation.eurder.service.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CreateItemGroupDto {

    private final String itemId;
    private final int amountToOrder;

    @JsonCreator
    public CreateItemGroupDto(String itemId, int amountToOrder) {
        this.itemId = itemId;
        this.amountToOrder = amountToOrder;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmountToOrder() {
        return amountToOrder;
    }
}
