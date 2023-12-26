package com.example.webfluxgateway.dto;

import lombok.Builder;
public record DisplayStoreResponseDto(Long id, String name, String thumbnailPath, int starRating, int deliveryFee) {

    @Builder
    public DisplayStoreResponseDto {
    }

}
