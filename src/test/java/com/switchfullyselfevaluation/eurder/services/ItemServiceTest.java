package com.switchfullyselfevaluation.eurder.services;

import com.switchfullyselfevaluation.eurder.domain.repositories.ItemRepository;
import com.switchfullyselfevaluation.eurder.domain.repositories.UserRepository;
import com.switchfullyselfevaluation.eurder.domain.user.Address;
import com.switchfullyselfevaluation.eurder.domain.user.Admin;
import com.switchfullyselfevaluation.eurder.domain.user.Customer;
import com.switchfullyselfevaluation.eurder.exceptions.NoAuthorizationException;
import com.switchfullyselfevaluation.eurder.exceptions.UserDoesNotExistException;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateItemDTO;
import com.switchfullyselfevaluation.eurder.services.mappers.ItemMapper;
import com.switchfullyselfevaluation.eurder.services.mappers.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {


    private ItemService itemService;
    private UserRepository userRepository;
    private Address address;
    private Customer customer;
   // private Admin admin;

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepository();
        address = new Address("Hoofdstraat, 1", "1000", "Brussel");
        customer = new Customer("Tom", "Degrote", "tom@degrote.be", address, "0478123654");
        userRepository.createCustomer(customer);
        itemService = new ItemService(new ItemRepository(), new ItemMapper(), new UserService(userRepository, new UserMapper()));
    }


    @DisplayName("When a customer adds item, throws NoAuthorizationException.")
    @Test
    void whenCustomerAddsItem_ThenAnExceptionIsThrown() {
        CreateItemDTO createItemDTO = new CreateItemDTO();
        Assertions.assertThrows(NoAuthorizationException.class, () -> itemService.createItem(createItemDTO, customer.getUuid()));
    }

    @DisplayName("When a customer id / customer does not exist, throws UserDoesNotExistException.")
    @Test
    void whenCustomerDoesNotExist_thenUserDoesNotExistException() {
        CreateItemDTO createItemDTO = new CreateItemDTO();
        Assertions.assertThrows(UserDoesNotExistException.class, () -> itemService.createItem(createItemDTO, "456"));
    }



}