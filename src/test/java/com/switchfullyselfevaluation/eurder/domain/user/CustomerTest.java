package com.switchfullyselfevaluation.eurder.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Address address1;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        address1 = new Address("HoofdStraat, 1", "1000", "Brussel");
        customer = new Customer("Tom", "Degrote", "tom@degrote.be", address1, "0478123654");
    }

    @Test
    public void givenNewCustomer_whenGettingUserRole_thenReturnCustomerRole() {
        //given
        //when
        //then
        Assertions.assertTrue(customer.getUserRole().equals(UserRole.CUSTOMER));
    }

}