package com.switchfullyselfevaluation.eurder.services.dtos;

import com.switchfullyselfevaluation.eurder.domain.Price;

import java.time.LocalDate;

public class CreateItemGroupDTO {

    private String itemId;
    private int amountToOrder;



    public String getItemId() {
        return itemId;
    }

    public int getAmountToOrder() {
        return amountToOrder;
    }

    public CreateItemGroupDTO setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public CreateItemGroupDTO setAmountToOrder(int amountToOrder) {
        this.amountToOrder = amountToOrder;
        return this;
    }
}
