package com.switchfullyselfevaluation.eurder.domain.repositories;

import com.switchfullyselfevaluation.eurder.domain.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {


    private final Map<String, Order> ordersById;

    public OrderRepository() {
        ordersById = new HashMap<>();
    }




}
