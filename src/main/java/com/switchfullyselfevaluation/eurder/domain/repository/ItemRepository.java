package com.switchfullyselfevaluation.eurder.domain.repository;

import com.switchfullyselfevaluation.eurder.domain.item.Item;
import com.switchfullyselfevaluation.eurder.domain.Price;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private final Map<String, Item> itemsById;
    Logger logger = LoggerFactory.getLogger(ItemRepository.class);

    public ItemRepository() {
        this.itemsById = new HashMap<>();

        Item item1 = new Item("Black diamond climbing rope", "Pink, anti rain coated, 80m", new Price(250.5, "€"), 10);
        Item item2 = new Item("Osprey lumina backpack", "Ugly but only 870g light", new Price(220, "€"), 2);
        Item item3 = new Item("MSR pocket rocket", "Smallest cooking stove", new Price(40, "€"), 1);
        this.itemsById.put(item1.getId(), item1);
        this.itemsById.put(item2.getId(), item2);
        this.itemsById.put(item3.getId(), item3);
        this.logger.warn(String.format("Item 1: %s", item1.getId()));
        this.logger.warn(String.format("Item 2: %s", item2.getId()));
        this.logger.warn(String.format("Item 3: %s", item3.getId()));
    }


    // STORY 2: Add Item as admin
    public void addItem(Item item) {
        itemsById.put(item.getId(), item);
        logger.info(String.format("ItemRepository: item %s added", item.getId()));
    }


    //helper (story 3)
    public Item getItem(String itemId) {
        return itemsById.get(itemId);
    }



}
