package com.switchfullyselfevaluation.eurder.services.mappers;

import com.switchfullyselfevaluation.eurder.domain.Order;
import com.switchfullyselfevaluation.eurder.domain.user.Customer;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateOrderDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {


    public Order toOrder(CreateOrderDTO createOrderDTO) {
        Order order = new Order(createOrderDTO.getCustomer(), createOrderDTO.getItemGroupSet());
        return order;
    }
}
