package com.switchfullyselfevaluation.eurder.service.dto;

import com.fasterxml.jackson.annotation.JsonCreator;


import java.util.List;


public class CreateOrderDto {

    private final List<CreateItemGroupDto> createItemGroups;

    @JsonCreator
    public CreateOrderDto(List<CreateItemGroupDto> createItemGroups) {
        this.createItemGroups = createItemGroups;
    }


    public List<CreateItemGroupDto> getCreateItemGroups() {
        return createItemGroups;
    }


}
