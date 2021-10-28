package com.switchfullyselfevaluation.eurder.domain;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {

    private final String uuid;
    private final String itemId;
    private final int amountToOrder;
    private final Price price;
    private final LocalDate shippingDate;

    public ItemGroup(String uuid, String itemId, int amountToOrder, Price price, LocalDate shippingDate) {
        this.uuid = UUID.randomUUID().toString();
        this.itemId = itemId;
        this.amountToOrder = amountToOrder;
        this.price = price;
        this.shippingDate = shippingDate;
    }

    public String getUuid() {
        return uuid;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmountToOrder() {
        return amountToOrder;
    }

    public Price getPrice() {
        return price;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

/*    public LocalDate calculateShippingDate() {

    }*/
}
