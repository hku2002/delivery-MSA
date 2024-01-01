package com.order.api.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderMenuRequestDto {

    private String name;
    private String description;
    private String thumbnailPath;
    private int price;
    private List<OrderMenuOptionRequestDto> options;

}
