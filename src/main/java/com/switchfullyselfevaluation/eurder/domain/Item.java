package com.switchfullyselfevaluation.eurder.domain;

import java.util.UUID;

public class Item {

    private final String uuid;
    private final String name;
    private final String description;
    private final Price price;
    private final int amountInStock;

    public Item(String name, String description, Price price, int amountInStock) {
        this.uuid = UUID.randomUUID().toString();
        this.name = validateStringNotNull(name);
        this.description = description;
        this.price = validatePriceNotNull(price);
        this.amountInStock = amountInStock;
    }

    public String getUuid() {
        return uuid;
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







    public String validateStringNotNull(String field) {
        if (field == null) {
            throw new IllegalArgumentException("Can't be null.");
        } else {
            return field;
        }
    }

    public Price validatePriceNotNull(Price price) {
        if(price == null) {
            throw new IllegalArgumentException("Price can't be null");
        } else {
            return price;
        }
    }



}
