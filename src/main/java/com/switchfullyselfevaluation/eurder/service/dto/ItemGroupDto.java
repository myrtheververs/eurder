package com.switchfullyselfevaluation.eurder.service.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDate;

public class ItemGroupDto {

    private final String itemId;
    private final int amountToOrder;
    private final LocalDate shippingDate;

    @JsonCreator
    public ItemGroupDto(String itemId, int amountToOrder, LocalDate shippingDate) {
        this.itemId = itemId;
        this.amountToOrder = amountToOrder;
        this.shippingDate = shippingDate;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmountToOrder() {
        return amountToOrder;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
