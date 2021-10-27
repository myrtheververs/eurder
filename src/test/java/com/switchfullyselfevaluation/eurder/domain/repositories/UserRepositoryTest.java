package com.switchfullyselfevaluation.eurder.domain.repositories;

import com.switchfullyselfevaluation.eurder.domain.user.Address;
import com.switchfullyselfevaluation.eurder.domain.user.Admin;
import com.switchfullyselfevaluation.eurder.domain.user.Customer;
import com.switchfullyselfevaluation.eurder.exceptions.InvalidUserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class UserRepositoryTest {

    private UserRepository userRepository;
    private Customer customer;
    private Customer customer2;
    private Admin admin;
    private Address address1;
    private Address address2;

    @BeforeEach
    public void SetUp() {
        userRepository = new UserRepository();
        address1 = new Address("HoofdStraat, 1", "1000", "Brussel");
        address2 = new Address("HoofdStraat, 2", "8000", "Brugge");
        customer = new Customer("Tom", "Degrote", "tom@degrote.be", address1, "0478123654");
        customer2 = new Customer("Martine", "Maartens", "martine@maartens.com", address2, "0445002005");

        //...
    }

    @Test
    public void givenCustomer_whenRegisteringInDatabase_thenDatabaseContainsId() {
        //given
        //when
        userRepository.createCustomer(customer);
        //then
        Assertions.assertTrue(userRepository.contains(customer.getUuid()));
    }

    @Test
    public void givenCustomerRegisteringInDatabase_whenFirstNameNull_thenExceptionThrown() {
        //given
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> userRepository.createCustomer(new Customer(null, "Jackson", "jackson@gmail.be", address1, "048635476")));
    }

    @Test
    public void givenCustomerRegisteringInDatabase_whenEmailAddressInvalid_thenExceptionThrown() {
        //given
        //then
        Assertions.assertThrows(InvalidUserException.class, () -> userRepository.createCustomer(new Customer("Jack", "Jackson", "nope.be", address1, "048635476")));
    }


}