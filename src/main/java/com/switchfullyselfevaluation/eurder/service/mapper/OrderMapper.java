package com.switchfullyselfevaluation.eurder.service.mapper;

import com.switchfullyselfevaluation.eurder.domain.item.Item;
import com.switchfullyselfevaluation.eurder.domain.itemgroup.ItemGroup;
import com.switchfullyselfevaluation.eurder.domain.order.Order;
import com.switchfullyselfevaluation.eurder.domain.Price;
import com.switchfullyselfevaluation.eurder.domain.repository.ItemRepository;

import com.switchfullyselfevaluation.eurder.service.dto.CreateItemGroupDto;
import com.switchfullyselfevaluation.eurder.service.dto.CreateOrderDto;
import com.switchfullyselfevaluation.eurder.service.dto.ItemGroupDto;
import com.switchfullyselfevaluation.eurder.service.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {


    private ItemRepository itemRepository;


    public OrderMapper(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }




    //STORY 3: add order as customer
    public Order toEntity(String customerId, CreateOrderDto createOrderDto) {

        List<ItemGroup> itemGroups = createOrderDto.getCreateItemGroups().stream()
                .map(this::toEntity)
                .collect(Collectors.toList());

        Price totalPrice = new Price(0, "€");

        for (ItemGroup itemGroup : itemGroups) {
            Item item = itemGroup.getItem();
            double priceValue = totalPrice.getValue() + (item.getPrice().getValue() * itemGroup.getAmountToOrder());
            totalPrice.setValue(priceValue);
        }

        return new Order(customerId, itemGroups, totalPrice);
    }


    //STORY 3: add order as customer

    public List<ItemGroup> toEntity(List<CreateItemGroupDto> createItemGroupDtoList) {
        return createItemGroupDtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public ItemGroup toEntity(CreateItemGroupDto createItemGroupDto) {
        return new ItemGroup(
                itemRepository.getItem(createItemGroupDto.getItemId()),
                createItemGroupDto.getAmountToOrder());

    }

    public OrderDto toDto(Order order) {
        return new OrderDto(order.getId(), this.toDto(order.getItemGroups()), order.getTotalPrice());
    }


    public List<ItemGroupDto> toDto(List<ItemGroup> itemGroups) {
        return itemGroups.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    public ItemGroupDto toDto(ItemGroup itemGroup) {
        return new ItemGroupDto(itemGroup.getItem().getId(), itemGroup.getAmountToOrder(), itemGroup.getShippingDate());
    }


}
