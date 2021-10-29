package com.switchfullyselfevaluation.eurder.services;

import com.switchfullyselfevaluation.eurder.domain.repositories.ItemRepository;
import com.switchfullyselfevaluation.eurder.domain.repositories.UserRepository;
import com.switchfullyselfevaluation.eurder.domain.user.Address;
import com.switchfullyselfevaluation.eurder.domain.user.Admin;
import com.switchfullyselfevaluation.eurder.domain.user.Customer;
import com.switchfullyselfevaluation.eurder.services.mappers.ItemMapper;
import com.switchfullyselfevaluation.eurder.services.mappers.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;
    private UserMapper userMapper;

    private Address address;



/*    @BeforeEach
    public void setUp() {
        userRepository = new UserRepository();
        address = new Address("Hoofdstraat, 1", "1000", "Brussel");
        customer = new Customer("Tom", "Degrote", "tom@degrote.be", address, "0478123654");

        admin = new Admin("An", "Min", "anmin@admin.com", address, "0478556654");

        userRepository.createCustomer(customer);
        userRepository.addUser(admin);

        userMapper = new UserMapper();
        userService = new UserService(userRepository, userMapper);
    }*/

}