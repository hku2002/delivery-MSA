package com.delivery.store.api.dto;

import lombok.Builder;

public record AddOptionRequestDto(Long menuId, String name, int price) {

    @Builder
    public AddOptionRequestDto {
    }

}
