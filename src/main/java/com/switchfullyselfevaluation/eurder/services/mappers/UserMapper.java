package com.switchfullyselfevaluation.eurder.services.mappers;

import com.switchfullyselfevaluation.eurder.domain.user.Customer;
import com.switchfullyselfevaluation.eurder.domain.user.User;
import com.switchfullyselfevaluation.eurder.services.dtos.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {


    public Customer toCustomer(UserDTO userDTO) {
        Customer customer = new Customer(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getAddress(), userDTO.getPhoneNumber());
        return customer;
    }

    public UserDTO toUserDTO(User user) {
        return new UserDTO()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setAddress(user.getAddress())
                .setPhoneNumber(user.getPhoneNumber());
    }
}
