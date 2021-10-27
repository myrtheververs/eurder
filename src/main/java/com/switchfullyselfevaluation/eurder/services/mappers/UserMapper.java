package com.switchfullyselfevaluation.eurder.services.mappers;

import com.switchfullyselfevaluation.eurder.domain.user.Customer;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateUserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public Customer toCustomer(CreateUserDTO createUserDTO) {
        Customer customer = new Customer(createUserDTO.getFirstName(), createUserDTO.getLastName(), createUserDTO.getEmail(), createUserDTO.getAddress(), createUserDTO.getPhoneNumber());
        return customer;
    }
}
