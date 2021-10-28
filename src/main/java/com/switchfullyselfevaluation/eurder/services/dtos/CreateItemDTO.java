package com.switchfullyselfevaluation.eurder.services.dtos;

import com.switchfullyselfevaluation.eurder.domain.Price;

public class CreateItemDTO {
    private String name;
    private String description;
    private Price price;
    private int amount;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public CreateItemDTO setName(String name) {
        this.name = name;
        return this;
    }

    public CreateItemDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public CreateItemDTO setPrice(Price price) {
        this.price = price;
        return this;

    }

    public CreateItemDTO setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
