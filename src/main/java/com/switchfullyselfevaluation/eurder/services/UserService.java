package com.switchfullyselfevaluation.eurder.services;

import com.switchfullyselfevaluation.eurder.domain.repositories.UserRepository;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateUserDTO;
import com.switchfullyselfevaluation.eurder.services.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void createCustomer(CreateUserDTO createUserDTO) {
        userRepository.createCustomer(userMapper.toCustomer(createUserDTO));
    }
}
