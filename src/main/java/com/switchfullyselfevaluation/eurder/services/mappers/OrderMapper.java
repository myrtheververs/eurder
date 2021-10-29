package com.switchfullyselfevaluation.eurder.services.mappers;

import com.switchfullyselfevaluation.eurder.domain.Item;
import com.switchfullyselfevaluation.eurder.domain.ItemGroup;
import com.switchfullyselfevaluation.eurder.domain.Order;
import com.switchfullyselfevaluation.eurder.domain.Price;
import com.switchfullyselfevaluation.eurder.domain.repositories.ItemRepository;
import com.switchfullyselfevaluation.eurder.services.ItemService;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateOrderDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    private final ItemRepository itemRepository;
    private final ItemGroupMapper itemGroupMapper;
    private final ItemService itemService;

    public OrderMapper(ItemRepository itemRepository, ItemGroupMapper itemGroupMapper, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemGroupMapper = itemGroupMapper;
        this.itemService = itemService;
    }

    public Order toOrder(String customerId, CreateOrderDTO createOrderDTO) {
        List<ItemGroup> itemGroups = createOrderDTO.getCreateItemGroupDTOList().stream()
                .map(itemGroupMapper::toEntity)
                .collect(Collectors.toList());

        Price totalPrice = new Price(0, "€");

        for (ItemGroup itemGroup: itemGroups) {
            Item item = itemService.getItemById(itemGroup.getItemId());
            double price = totalPrice.getValue() + item.getPrice().getValue() * itemGroup.getAmountToOrder();
            totalPrice.setValue(price);
        }

        return new Order(customerId, itemGroups, totalPrice);
    }
}
