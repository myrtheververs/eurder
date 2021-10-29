package com.switchfullyselfevaluation.eurder.domain.repositories;

import com.switchfullyselfevaluation.eurder.domain.Item;
import com.switchfullyselfevaluation.eurder.domain.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private final Map<String, Item> itemsById;

    public ItemRepository() {
        itemsById = new HashMap<>();

       Item item = new Item("Iphone", "expensive phone", new Price(800, "€"), 10);
       Item item2 = new Item("Book", "to read", new Price(8, "€"), 5);
       itemsById.put(item.getUuid(), item);
       itemsById.put(item2.getUuid(), item2);
    }

    public void addItem(Item item) {
        itemsById.put(item.getUuid(), item);
    }

    public Item getItemById(String id) {
        return itemsById.get(id);
    }

    public List<Item> getAll() {
        return new ArrayList<>(itemsById.values());
    }






}
