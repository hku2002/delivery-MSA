package com.order.api.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequestDto {

    private Long storeId;
    private List<OrderMenuRequestDto> orderMenu;

}
