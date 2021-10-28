package com.switchfullyselfevaluation.eurder.domain;

import com.switchfullyselfevaluation.eurder.domain.user.Customer;

import java.util.Set;
import java.util.UUID;

public class Order {

    private String uuid;
    private Customer customer;
    private Set<ItemGroup> itemGroupSet;

    public Order(Customer customer, Set<ItemGroup> itemGroupSet) {
        this.uuid = UUID.randomUUID().toString();
        this.customer = customer;
        this.itemGroupSet = itemGroupSet;
    }

    public String getUuid() {
        return uuid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<ItemGroup> getItemGroupSet() {
        return itemGroupSet;
    }
}
