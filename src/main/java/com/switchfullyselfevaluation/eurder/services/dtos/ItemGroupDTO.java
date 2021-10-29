package com.switchfullyselfevaluation.eurder.services.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDate;

public class ItemGroupDTO {

    private String itemId;
    private int amountToOrder;
    private LocalDate shippingDate;

    @JsonCreator
    public ItemGroupDTO(String itemId, int amountToOrder, LocalDate shippingDate) {
        this.itemId = itemId;
        this.amountToOrder = amountToOrder;
        this.shippingDate = shippingDate;
    }

    public ItemGroupDTO setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemGroupDTO setAmountToOrder(int amountToOrder) {
        this.amountToOrder = amountToOrder;
        return this;
    }

    public ItemGroupDTO setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
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
