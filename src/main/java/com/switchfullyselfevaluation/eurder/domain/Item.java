package com.switchfullyselfevaluation.eurder.domain;

import java.util.UUID;

public class Item {

    private final String uuid;
    private final String name;
    private final String description;
    private final Price price;
    private final int amount;

    public Item(String name, String description, Price price, int amount) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }
}
