package com.switchfullyselfevaluation.eurder.controllers;

import com.switchfullyselfevaluation.eurder.services.UserService;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserContoller {

    private final UserService userService;

    public final Logger logger = LoggerFactory.getLogger(UserContoller.class);

    @Autowired
    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CreateUserDTO createUserDTO) {
        userService.createCustomer(createUserDTO);
        logger.info("Controller: New customer registered/created");
    }
}
