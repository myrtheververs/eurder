package com.switchfullyselfevaluation.eurder.services;

import com.switchfullyselfevaluation.eurder.domain.repositories.UserRepository;
import com.switchfullyselfevaluation.eurder.domain.user.Customer;
import com.switchfullyselfevaluation.eurder.domain.user.User;
import com.switchfullyselfevaluation.eurder.domain.user.UserRole;
import com.switchfullyselfevaluation.eurder.exceptions.NoAuthorizationException;
import com.switchfullyselfevaluation.eurder.exceptions.NotACustomerException;
import com.switchfullyselfevaluation.eurder.exceptions.UserDoesNotExistException;
import com.switchfullyselfevaluation.eurder.services.dtos.UserDTO;
import com.switchfullyselfevaluation.eurder.services.mappers.UserMapper;
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

    public void createCustomer(UserDTO userDTO) {
        userRepository.createCustomer(userMapper.toCustomer(userDTO));
    }

    public List<UserDTO> getAllCustomers(String uuidUser) {
        assertAdminId(uuidUser);

        return userRepository.getAll().stream()
                .filter(u -> u.getUserRole() == UserRole.CUSTOMER)
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    private void assertAdminId(String uuidUser) {
        if(getUserById(uuidUser).getUserRole() != UserRole.ADMIN) {
            throw new NoAuthorizationException("No admin rights");
        }
    }

    public User getUserById(String uuidUser) {
        if (userRepository.getUsersById().get(uuidUser) == null) {
            throw new UserDoesNotExistException("User not found");
        } else {
            return userRepository.getUsersById().get(uuidUser);
        }
    }

    public UserDTO getCustomerById(String uuidAdmin, String uuidCustomer) {
        assertAdminId(uuidAdmin);
        assertCustomerId(uuidCustomer);
        return userMapper.toUserDTO(this.getUserById(uuidCustomer));
    }

    private void assertCustomerId(String uuidUser) {
        if(getUserById(uuidUser).getUserRole() != UserRole.CUSTOMER) {
            throw new NotACustomerException("Not a customer");
        }
    }



}
