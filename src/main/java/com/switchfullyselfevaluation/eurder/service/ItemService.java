package com.switchfullyselfevaluation.eurder.service;

import com.switchfullyselfevaluation.eurder.domain.item.Item;
import com.switchfullyselfevaluation.eurder.domain.repository.ItemRepository;

import com.switchfullyselfevaluation.eurder.exception.InvalidItemException;
import com.switchfullyselfevaluation.eurder.exception.InvalidUserException;
import com.switchfullyselfevaluation.eurder.exception.NoAuthorizationException;

import com.switchfullyselfevaluation.eurder.service.dto.CreateItemDto;
import com.switchfullyselfevaluation.eurder.service.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ItemService {


    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    private UserService userService;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper, UserService userService) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.userService = userService;
    }


    //STORY 2: Add item as admin
    public void addItem(String adminId, CreateItemDto createItemDto) {
        if(userService.getUser(adminId) == null) {
            throw new InvalidUserException("User not found");
        }
        if(!userService.isAdmin(adminId)) {
            throw new NoAuthorizationException("No admin rights");
        }
        else if(assertValidItem(createItemDto)) {
            itemRepository.addItem(itemMapper.toEntity(createItemDto));
        }
    }



    // Helper methods
    public Item getItemById(String itemId) {
        return itemRepository.getItem(itemId);
    }

    public boolean assertValidItem(CreateItemDto createItemDto) {
        if(createItemDto.getName() == null || createItemDto.getName().isBlank()) {
            throw new InvalidItemException("Invalid item: provide an item name");
        }
        if(createItemDto.getPrice() == null || createItemDto.getPrice().getValue() == 0) {
            throw new InvalidItemException(("Invalid item: provide a valid price"));
        }
        return true;
    }


}
