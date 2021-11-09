package com.switchfullyselfevaluation.eurder.domain.itemgroup;

import com.switchfullyselfevaluation.eurder.domain.item.Item;

import java.time.LocalDate;

public class ItemGroup {

    private final Item item;
    private final int amountToOrder;
    private final LocalDate shippingDate;

    public ItemGroup(Item item, int amountToOrder) {
        this.item = item;
        this.amountToOrder = amountToOrder;
        this.shippingDate = calculateShippingDate();
    }

    public Item getItem() {
        return item;
    }

    public int getAmountToOrder() {
        return amountToOrder;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }





    //calculate shipping methods
    private LocalDate calculateShippingDate() {
        return itemIsInStock() ? LocalDate.now().plusDays(1) : LocalDate.now().plusDays(7);
    }

    private boolean itemIsInStock() {
        return this.item.getAmountInStock() >= amountToOrder;
    }



}
