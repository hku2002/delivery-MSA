package com.delivery.store.api.dto;

import lombok.Builder;

public record AddMenuRequestDto(Long storeId, String name, String description, String thumbnailPath, int price) {

    @Builder
    public AddMenuRequestDto {
    }

}
