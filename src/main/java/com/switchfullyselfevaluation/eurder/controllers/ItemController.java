package com.switchfullyselfevaluation.eurder.controllers;

import com.switchfullyselfevaluation.eurder.service.ItemService;

import com.switchfullyselfevaluation.eurder.service.dto.CreateItemDto;

import com.switchfullyselfevaluation.eurder.service.dto.ItemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    //POST : STORY 2 - add item as admin
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestHeader(value = "id") String adminId,
                        @RequestBody CreateItemDto createItemDto) {
        logger.info("Trying to add item");
        itemService.addItem(adminId, createItemDto);
        logger.info("Item added");
    }

    /*//GET
    @GetMapping( produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }*/
}
