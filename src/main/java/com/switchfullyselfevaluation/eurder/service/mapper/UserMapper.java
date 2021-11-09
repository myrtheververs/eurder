package com.switchfullyselfevaluation.eurder.service.mapper;

import com.switchfullyselfevaluation.eurder.domain.user.User;

import com.switchfullyselfevaluation.eurder.service.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    //Story 1: register customer
    public User toEntity(UserDto userDto) {
        return new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getAddress(),
                userDto.getPhoneNumber()
        );
    }

    //Story 7: view all customers as admin
    public UserDto toDto(User user) {
        return new UserDto(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAddress(),
                user.getPhoneNumber()
        );
    }
}
