package com.switchfullyselfevaluation.eurder.services.dtos;

import com.switchfullyselfevaluation.eurder.domain.ItemGroup;
import com.switchfullyselfevaluation.eurder.domain.user.Customer;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CreateOrderDTO {

    private Customer customer;
    private Set<ItemGroup> itemGroupSet;



    public Customer getCustomer() {
        return customer;
    }
    public Set<ItemGroup> getItemGroupSet() {
        return itemGroupSet;
    }

    public CreateOrderDTO Customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public CreateOrderDTO setItemGroupSet(Set<ItemGroup> itemGroupSet) {
        this.itemGroupSet = itemGroupSet;
        return this;
    }
}
