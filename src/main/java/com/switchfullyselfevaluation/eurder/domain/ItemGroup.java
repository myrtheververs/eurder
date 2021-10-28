package com.switchfullyselfevaluation.eurder.domain;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {

    private String uuid;
    private String itemId;
    private int amount;
    private Price price;
    private LocalDate shippingDate;

    public ItemGroup(String uuid, String itemId, int amount, Price price, LocalDate shippingDate) {
        this.uuid = UUID.randomUUID().toString();
        this.itemId = itemId;
        this.amount = amount;
        this.price = price;
        this.shippingDate = shippingDate;
    }


}
