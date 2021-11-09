package com.switchfullyselfevaluation.eurder.service;

import com.switchfullyselfevaluation.eurder.domain.repository.UserRepository;
import com.switchfullyselfevaluation.eurder.domain.user.User;
import com.switchfullyselfevaluation.eurder.domain.user.UserRole;
import com.switchfullyselfevaluation.eurder.exception.InvalidUserException;
import com.switchfullyselfevaluation.eurder.exception.NoAuthorizationException;

import com.switchfullyselfevaluation.eurder.service.dto.UserDto;
import com.switchfullyselfevaluation.eurder.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }



    // STORY 1: register customer
    public void registerCustomer(UserDto userDto) {
        userRepository.registerCustomer(userMapper.toEntity(userDto));
    }


    //STORY 7: view all customers as admin
    public List<UserDto> getCustomers(String adminId) {
        if(this.getUser(adminId) == null) {
            throw new InvalidUserException("User not found");
        }
        if(!this.isAdmin(adminId)) {
            throw new NoAuthorizationException("No admin rights");
        }

        return userRepository.getUsers().stream()
                .filter(user -> user.getUserRole() == UserRole.CUSTOMER)
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    //STORY 8: view single customer as admin
    public User getCustomer(String adminId, String customerId) {
        if(this.getUser(adminId) == null) {
            throw new InvalidUserException("User not found");
        }
        if(!this.isAdmin(adminId)) {
            throw new NoAuthorizationException("No admin rights");
        }
        if(this.getUser(customerId) == null){
            throw new InvalidUserException("Customer can't be null");
        }
        if(!userRepository.isCustomer(customerId)) {
            throw new InvalidUserException("Customer not found");
        }

        return userRepository.getUser(customerId);
    }



    //HELPERS
    public boolean isAdmin(String userId) {
        return userRepository.isAdmin(userId);
    }

    public User getUser(String userId) {
        return userRepository.getUser(userId);
    }



}
