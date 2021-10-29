package com.switchfullyselfevaluation.eurder.controllers;

import com.switchfullyselfevaluation.eurder.services.UserService;
import com.switchfullyselfevaluation.eurder.services.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping( "/users")
public class UserContoller {

    private final UserService userService;

    public final Logger logger = LoggerFactory.getLogger(UserContoller.class);

    @Autowired
    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    //POST
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody UserDTO userDTO) {
        try {
            logger.info("Controller: trying to create new customer");
            userService.createCustomer(userDTO);
            logger.info("Controller: new customer created");
        } catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }

    }

    //GET
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllCustomers(@RequestHeader(value = "uuid") String uuidUser) {

        logger.info("Trying to get all customers");
        return userService.getAllCustomers(uuidUser);
    }

    @GetMapping(path = "/{uuidCustomer}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getCustomerById(@RequestHeader(value = "uuid") String uuidUser,
                                   @PathVariable String uuidCustomer) {

        logger.info("Trying to get single customer by id");
        return userService.getCustomerById(uuidUser, uuidCustomer);
    }
}
