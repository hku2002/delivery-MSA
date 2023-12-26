package com.example.webfluxgateway.dto;

import lombok.Builder;

import java.util.List;

public record HomeResponseDto(AddressResponseDto address, List<DisplayStoreResponseDto> displayStores) {
    @Builder
    public HomeResponseDto {
    }
}
