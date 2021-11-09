package com.switchfullyselfevaluation.eurder.service;

import com.switchfullyselfevaluation.eurder.domain.Price;
import com.switchfullyselfevaluation.eurder.domain.repository.ItemRepository;
import com.switchfullyselfevaluation.eurder.domain.repository.UserRepository;
import com.switchfullyselfevaluation.eurder.domain.user.Address;

import com.switchfullyselfevaluation.eurder.domain.user.User;
import com.switchfullyselfevaluation.eurder.domain.user.UserRole;
import com.switchfullyselfevaluation.eurder.exception.InvalidItemException;
import com.switchfullyselfevaluation.eurder.exception.InvalidUserException;
import com.switchfullyselfevaluation.eurder.exception.NoAuthorizationException;

import com.switchfullyselfevaluation.eurder.service.dto.CreateItemDto;
import com.switchfullyselfevaluation.eurder.service.mapper.ItemMapper;
import com.switchfullyselfevaluation.eurder.service.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemServiceTest {

    private ItemService itemService;
    private UserRepository userRepository;
    private Address address;
    private User customer;
    private User admin;
    private CreateItemDto createItemDto;

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepository();
        address = new Address("Hoofdstraat, 1", "1000", "Brussel");
        customer = new User("Tom", "Degrote", "tom@degrote.be", address, "0478123654");

        admin = new User("An", "Min", "anmin@admin.com", address, "0478556654", UserRole.ADMIN);

        userRepository.registerCustomer(customer);
        userRepository.addUser(admin);

        itemService = new ItemService(new ItemRepository(), new ItemMapper(),  new UserService(userRepository, new UserMapper()));

        createItemDto = new CreateItemDto("New item name", "Item description", new Price(5, "€"), 10);
    }

    //authorization create item
    @DisplayName("When a customer adds item, throws NoAuthorizationException.")
    @Test
    void whenCustomerAddsItem_ThenExceptionIsThrown() {
        Assertions.assertThrows(NoAuthorizationException.class, () -> itemService.addItem(customer.getId(), createItemDto));
    }

    @DisplayName("When a customer id / customer does not exist, throws InvalidUserException.")
    @Test
    void givenCustomerDoesNotExist_whenAddsItem_thenExistExceptionThrown() {
        Assertions.assertThrows(InvalidUserException.class, () -> itemService.addItem("456", createItemDto));
    }


    //valid fields create item
    @DisplayName("When admin creates item with no name, throws InvalidItemException")
    @Test
    void givenAdminCreatesItem_whenItemNameIsNull_thenExceptionThrown() {
        CreateItemDto createItemDto2 = new CreateItemDto(null, "Item description", new Price(5, "€"), 10);
        Assertions.assertThrows(InvalidItemException.class, () -> itemService.addItem( admin.getId(), createItemDto2));
    }

    @DisplayName("When admin creates item with no price, throws InvalidItemException")
    @Test
    void givenAdminCreatesItem_whenItemPriceIsNull_thenExceptionThrown() {
        CreateItemDto createItemDto3 = new CreateItemDto(null, "Item description", null, 10);
        Assertions.assertThrows(InvalidItemException.class, () -> itemService.addItem(admin.getId(), createItemDto3));
    }


}