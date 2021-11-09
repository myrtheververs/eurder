package com.switchfullyselfevaluation.eurder.domain.order;

import com.switchfullyselfevaluation.eurder.domain.Price;
import com.switchfullyselfevaluation.eurder.domain.itemgroup.ItemGroup;

import java.util.List;
import java.util.UUID;

public class Order {


    private final String id;
    private final String customerId;
    private final List<ItemGroup> itemGroups;
    private final Price totalPrice;

    public Order(String customerId, List<ItemGroup> itemGroups, Price totalPrice) {
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.itemGroups = itemGroups;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }

}
