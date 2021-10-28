package com.switchfullyselfevaluation.eurder.domain;

import com.switchfullyselfevaluation.eurder.domain.repositories.ItemRepository;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {

    private final String uuid;
    private final String itemId;
    private final int amountToOrder;
    private final Price price;
    private final LocalDate shippingDate;

    private ItemRepository itemRepository;

    public ItemGroup(String uuid, String itemId, int amountToOrder, Price price, LocalDate shippingDate) {
        this.uuid = UUID.randomUUID().toString();
        this.itemId = itemId;
        this.amountToOrder = amountToOrder;
        this.price = getItemById(itemId).getPrice();
        this.shippingDate = calculateShippingDate();
    }

    private Item getItemById(String itemId) {
        Item item = itemRepository.getItemById(itemId);
        return item;
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

    public LocalDate calculateShippingDate() {
        if (getItemById(itemId).getAmountInStock() < amountToOrder) {
            return LocalDate.now().plusDays(7);
        } else {
            return LocalDate.now().plusDays(1);
        }
    }
}
