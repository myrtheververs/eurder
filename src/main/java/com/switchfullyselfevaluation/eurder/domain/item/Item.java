package com.switchfullyselfevaluation.eurder.domain.item;

import com.switchfullyselfevaluation.eurder.domain.Price;

import java.util.UUID;

public class Item {

    private final String id;
    private final String name;
    private final String description;
    private final Price price;
    private final int amountInStock;

    public Item(String name, String description, Price price, int amountInStock) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    public Item(String id, String name, String description, Price price, int amountInStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    public String getId() {
        return id;
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

    //method decrease amount ?



}
