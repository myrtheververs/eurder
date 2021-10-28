package com.switchfullyselfevaluation.eurder.services;

import com.switchfullyselfevaluation.eurder.domain.repositories.ItemRepository;
import com.switchfullyselfevaluation.eurder.domain.user.User;
import com.switchfullyselfevaluation.eurder.domain.user.UserRole;
import com.switchfullyselfevaluation.eurder.exceptions.NoAuthorizationException;
import com.switchfullyselfevaluation.eurder.exceptions.UserDoesNotExistException;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateItemDTO;
import com.switchfullyselfevaluation.eurder.services.mappers.ItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final UserService userService;


    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper, UserService userService) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.userService = userService;
    }

    public void createItem(CreateItemDTO createItemDTO, String uuid) {
        User user = userService.getUserById(uuid);

        if(userService.getUserById(uuid) == null) {
            throw new UserDoesNotExistException("User not found");
        }
        if(user.getUserRole() != UserRole.ADMIN) {
            throw new NoAuthorizationException("You have no authorization to add an item");  //ok
        }

        itemRepository.addItem(itemMapper.toItem(createItemDTO));   //ok

    }


}
