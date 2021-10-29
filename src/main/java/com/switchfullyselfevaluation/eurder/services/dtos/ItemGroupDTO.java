package com.switchfullyselfevaluation.eurder.services.dtos;

import java.time.LocalDate;

public class ItemGroupDTO {

    private String itemId;
    private int amountToOrder;
    private LocalDate shippingDate;


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
