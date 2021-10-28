package com.switchfullyselfevaluation.eurder.domain.repositories;

import com.switchfullyselfevaluation.eurder.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {

    private final Map<String, Order> ordersById;

    public OrderRepository() {
        ordersById = new HashMap<>();
    }

    public Order addOrder(Order order) {
        return ordersById.put(order.getUuid(), order);
    }




}
