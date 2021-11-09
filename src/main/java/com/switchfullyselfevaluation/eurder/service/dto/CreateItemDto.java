package com.switchfullyselfevaluation.eurder.service.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.switchfullyselfevaluation.eurder.domain.Price;

public class CreateItemDto {
    private final String name;
    private final String description;
    private final Price price;
    private final int amountInStock;

    @JsonCreator
    public CreateItemDto(String name, String description, Price price, int amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }
}
