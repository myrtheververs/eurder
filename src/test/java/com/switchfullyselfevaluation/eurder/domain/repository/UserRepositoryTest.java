package com.switchfullyselfevaluation.eurder.domain.repository;

import com.switchfullyselfevaluation.eurder.domain.user.Address;

import com.switchfullyselfevaluation.eurder.domain.user.User;
import com.switchfullyselfevaluation.eurder.domain.user.UserRole;
import com.switchfullyselfevaluation.eurder.exception.InvalidUserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class UserRepositoryTest {

        private UserRepository userRepository;
        private User customer;
        private User admin;
        private Address address1;
        private Address address2;

        @BeforeEach
        public void SetUp() {
            userRepository = new UserRepository();
            address1 = new Address("HoofdStraat, 1", "1000", "Brussel");
            address2 = new Address("HoofdStraat, 2", "8000", "Brugge");
            customer = new User("Tom", "Degrote", "tom@degrote.be", address1, "0478123654");
            admin = new User("Martine", "Maartens", "martine@maartens.com", address2, "0445002005", UserRole.ADMIN);

        }

        @Test
        public void givenCustomer_whenRegisteringInDatabase_thenDatabaseContainsId() {
            //given
            //when
            userRepository.registerCustomer(customer);
            //then
            Assertions.assertTrue(userRepository.getUser(customer.getId()) == customer);
        }

        @Test
        public void givenCustomerRegisteringInDatabase_whenFirstNameNull_thenExceptionThrown() {
            //given
            //then
            Assertions.assertThrows(InvalidUserException.class, () -> userRepository.registerCustomer(new User(null, "Jackson", "jackson@gmail.com", address1, "048635476")));
        }

        @Test
        public void givenCustomerRegisteringInDatabase_whenEmailAddressInvalid_thenExceptionThrown() {
            //given
            //then
            Assertions.assertThrows(InvalidUserException.class, () -> userRepository.registerCustomer(new User("Jack", "Jackson", "nope.com", address1, "048635476")));
        }



        //user role
        @Test
        public void givenNewCustomer_whenGettingUserRole_thenReturnCustomerRole() {
            //given
            //when
            //then
            Assertions.assertTrue(customer.getUserRole().equals(UserRole.CUSTOMER));
        }


    }

