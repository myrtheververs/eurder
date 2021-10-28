package com.switchfullyselfevaluation.eurder.controllers;

import com.switchfullyselfevaluation.eurder.services.OrderService;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateOrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = "application/json", produces = "appliction/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@RequestBody CreateOrderDTO createOrderDTO,
                             @RequestHeader(value = "uuid") String uuidUser) {

        logger.info("Trying to create order");
        orderService.addOrder(createOrderDTO, uuidUser);
        logger.info("Created order");

    }
}
