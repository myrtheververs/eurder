package com.switchfullyselfevaluation.eurder.services.dtos;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateOrderDTO {


    private List<CreateItemGroupDTO> createItemGroupDTOList;


    public List<CreateItemGroupDTO> getCreateItemGroupDTOList() {
        return createItemGroupDTOList;
    }

    public CreateOrderDTO setCreateItemGroupDTOList(List<CreateItemGroupDTO> createItemGroupDTOList) {
        this.createItemGroupDTOList = createItemGroupDTOList;
        return this;
    }
}
