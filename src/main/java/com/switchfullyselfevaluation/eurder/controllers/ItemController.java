package com.switchfullyselfevaluation.eurder.controllers;

import com.switchfullyselfevaluation.eurder.exceptions.NoAuthorizationException;
import com.switchfullyselfevaluation.eurder.exceptions.UserDoesNotExistException;
import com.switchfullyselfevaluation.eurder.services.ItemService;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestHeader(value = "uuid", required = true) String uuid,
                           @RequestBody CreateItemDTO createItemDTO) {
        try {
            itemService.createItem(createItemDTO, uuid);
            logger.info("Controller: creating new item");
        } catch (UserDoesNotExistException | NoAuthorizationException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }
}
