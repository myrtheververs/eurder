package com.switchfullyselfevaluation.eurder.controllers;

import com.switchfullyselfevaluation.eurder.domain.user.User;
import com.switchfullyselfevaluation.eurder.service.UserService;
import com.switchfullyselfevaluation.eurder.service.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    //POST : Story 1
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerCustomer(@RequestBody UserDto userDto) {
        logger.info("Trying to create new customer");
        userService.registerCustomer(userDto);
        logger.info("New customer created");
    }

    //GET : Story 7
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getCustomers(@RequestHeader(value = "adminId") String adminId) {
        logger.info("Getting all customers...");
        return userService.getCustomers(adminId);
    }

    //GET : Story 8
    @GetMapping(path = "/{customerId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public User getCustomer(@RequestHeader(value = "adminId") String adminId,
                            @PathVariable String customerId){
        logger.info("Getting customer details...");
        return userService.getCustomer(adminId, customerId);
    }
}
