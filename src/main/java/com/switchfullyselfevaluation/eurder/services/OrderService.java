package com.switchfullyselfevaluation.eurder.services;

import com.switchfullyselfevaluation.eurder.domain.repositories.OrderRepository;
import com.switchfullyselfevaluation.eurder.domain.user.User;
import com.switchfullyselfevaluation.eurder.domain.user.UserRole;
import com.switchfullyselfevaluation.eurder.exceptions.NoAuthorizationException;
import com.switchfullyselfevaluation.eurder.exceptions.UserDoesNotExistException;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateOrderDTO;
import com.switchfullyselfevaluation.eurder.services.mappers.OrderMapper;
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

    public void addOrder(CreateOrderDTO createOrderDTO, String uuidUser) {
        User user = userService.getUserById(uuidUser);

        if(userService.getUserById(uuidUser) == null) {
            throw new UserDoesNotExistException("User not found");
        }
        if(user.getUserRole() != UserRole.CUSTOMER) {
            throw new NoAuthorizationException("You have to be a customer to make an order");
        }

        orderRepository.addOrder(orderMapper.toOrder(createOrderDTO));
    }
}
