package com.switchfullyselfevaluation.eurder.domain.repositories;

import com.switchfullyselfevaluation.eurder.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepository {

    private final Map<String, Item> itemsById;

    public ItemRepository() {
        itemsById = new HashMap<>();
    }

    public void addItem(Item item) {
        itemsById.put(item.getUuid(), item);
    }

    public Item getItemById(String id) {
        return itemsById.get(id);
    }






}
