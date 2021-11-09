package com.switchfullyselfevaluation.eurder.domain.repository;

import com.switchfullyselfevaluation.eurder.domain.order.Order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {

    private final Map<String, Order> ordersById;
    private final Logger logger = LoggerFactory.getLogger(OrderRepository.class);

    public OrderRepository() {
        this.ordersById = new HashMap<>();
    }


    // STORY 3 : add order as customer
    public Order addOrder(String customerId, Order order) {
        ordersById.put(order.getId(), order);
        logger.info(String.format("OrderRepository: customer %s made order with id %s ", order.getCustomerId(), order.getId()));
        return ordersById.get(order.getId());
    }
}
