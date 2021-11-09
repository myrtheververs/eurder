package com.switchfullyselfevaluation.eurder.service;

import com.switchfullyselfevaluation.eurder.domain.order.Order;
import com.switchfullyselfevaluation.eurder.domain.repository.OrderRepository;
import com.switchfullyselfevaluation.eurder.domain.user.User;
import com.switchfullyselfevaluation.eurder.domain.user.UserRole;
import com.switchfullyselfevaluation.eurder.exception.InvalidUserException;
import com.switchfullyselfevaluation.eurder.exception.NoAuthorizationException;
import com.switchfullyselfevaluation.eurder.service.dto.CreateOrderDto;
import com.switchfullyselfevaluation.eurder.service.dto.OrderDto;
import com.switchfullyselfevaluation.eurder.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserService userService;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, UserService userService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.userService = userService;
    }


    //STORY 3 : add order as customer
    public OrderDto addOrder(String customerId, CreateOrderDto createOrderDto) {

        User user = userService.getUser(customerId);

        if(userService.getUser(customerId) == null) {
            throw new InvalidUserException("User not found");
        }
        if(user.getUserRole() != UserRole.CUSTOMER) {
            throw new NoAuthorizationException("You have to be a registered customer to make an order");
        }


        Order order = orderMapper.toEntity(customerId, createOrderDto);
        orderRepository.addOrder(order.getId(), order);

        //TO DO : decrease amount of item.

        return orderMapper.toDto(order);
    }
}
