package com.switchfullyselfevaluation.eurder.domain;

import com.switchfullyselfevaluation.eurder.domain.user.Customer;

import java.util.Set;

public class Order {

    private String uuid;
    private Customer customer;
    private Set<ItemGroup> itemGroupSet;

    public Order(String uuid, Customer customer, Set<ItemGroup> itemGroupSet) {
        this.uuid = uuid;
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
