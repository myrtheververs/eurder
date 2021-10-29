package com.switchfullyselfevaluation.eurder.domain;

import com.switchfullyselfevaluation.eurder.domain.repositories.ItemRepository;

import java.time.LocalDate;

public class ItemGroup {

    private final String itemId;
    private final int amountToOrder;
    private final LocalDate shippingDate;

    private ItemRepository itemRepository;

    public ItemGroup(String itemId, int amountToOrder, LocalDate shippingDate) {
        this.itemId = itemId;
        this.amountToOrder = amountToOrder;

        this.shippingDate = shippingDate;
    }





    public String getItemId() {
        return itemId;
    }

    public int getAmountToOrder() {
        return amountToOrder;
    }



    public LocalDate getShippingDate() {
        return shippingDate;
    }


   /* public LocalDate calculateShippingDate() {
        if (isInStock()) {
            return LocalDate.now().plusDays(7);
        } else {
            return LocalDate.now().plusDays(1);
        }
    }
*/


   /* public boolean isInStock() {
        return getItemById(itemId).getAmountInStock() - amountToOrder >= 0;
    }*/


}
