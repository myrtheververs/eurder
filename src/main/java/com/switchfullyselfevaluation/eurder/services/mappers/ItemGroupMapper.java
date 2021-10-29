package com.switchfullyselfevaluation.eurder.services.mappers;

import com.switchfullyselfevaluation.eurder.domain.ItemGroup;
import com.switchfullyselfevaluation.eurder.services.dtos.CreateItemGroupDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ItemGroupMapper {

    public ItemGroup toEntity(CreateItemGroupDTO createItemGroupDTO) {

        LocalDate shippingDate = LocalDate.now().plusDays(1);

        return new ItemGroup(createItemGroupDTO.getItemId(), createItemGroupDTO.getAmountToOrder(), shippingDate);
    }
}
