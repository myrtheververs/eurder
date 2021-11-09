package com.switchfullyselfevaluation.eurder.controllers;

import com.switchfullyselfevaluation.eurder.service.OrderService;
import com.switchfullyselfevaluation.eurder.service.dto.CreateOrderDto;
import com.switchfullyselfevaluation.eurder.service.dto.OrderDto;
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

    //POST
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto addOrder(@RequestHeader(value = "customerId") String customerId,
                             @RequestBody CreateOrderDto createOrderDto) {
        logger.info("Creating order...");
        return orderService.addOrder(customerId, createOrderDto);
    }
}
