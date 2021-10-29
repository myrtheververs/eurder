package com.switchfullyselfevaluation.eurder.domain;

import java.util.List;
import java.util.UUID;

public class Order {

    private String uuid;
    private String customerId;
    private List<ItemGroup> itemGroupSet;
    private Price totalPrice;

    public Order(String customerId, List<ItemGroup> itemGroupSet, Price totalPrice) {
        this.totalPrice = totalPrice;

        this.uuid = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.itemGroupSet = itemGroupSet;
    }

    public String getUuid() {
        return uuid;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<ItemGroup> getItemGroupSet() {
        return itemGroupSet;
    }
}
