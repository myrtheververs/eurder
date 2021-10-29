package com.switchfullyselfevaluation.eurder.services;

import com.switchfullyselfevaluation.eurder.domain.Item;
import com.switchfullyselfevaluation.eurder.domain.repositories.ItemRepository;
import com.switchfullyselfevaluation.eurder.domain.user.User;
import com.switchfullyselfevaluation.eurder.domain.user.UserRole;
import com.switchfullyselfevaluation.eurder.exceptions.NoAuthorizationException;
import com.switchfullyselfevaluation.eurder.exceptions.UserDoesNotExistException;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateItemDTO;
import com.switchfullyselfevaluation.eurder.services.dtos.ItemDTO;
import com.switchfullyselfevaluation.eurder.services.dtos.UserDTO;
import com.switchfullyselfevaluation.eurder.services.mappers.CreateItemMapper;
import com.switchfullyselfevaluation.eurder.services.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final CreateItemMapper createItemMapper;
    private final UserService userService;


    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper, CreateItemMapper createItemMapper, UserService userService) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.createItemMapper = createItemMapper;
        this.userService = userService;
    }

    public void createItem(CreateItemDTO createItemDTO, String uuidUser) {
        User user = userService.getUserById(uuidUser);

        if(userService.getUserById(uuidUser) == null) {
            throw new UserDoesNotExistException("User not found");
        }
        if(user.getUserRole() != UserRole.ADMIN) {
            throw new NoAuthorizationException("You have no authorization to add an item");
        }

        itemRepository.addItem(createItemMapper.toItem(createItemDTO));

    }

    public Item getItemById(String itemId) {
        return itemRepository.getItemById(itemId);
    }


    public List<ItemDTO> getAllItems() {

        return itemRepository.getAll().stream()
                .map(itemMapper::toItemDTO)
                .collect(Collectors.toList());
    }


/*    public boolean isInStock(String itemId) {
        return getItemById(itemId).getAmountInStock() - amountToOrder >= 0;
    }*/


}
