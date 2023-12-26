package com.example.webfluxgateway.dto;

import lombok.Builder;

public record AddressResponseDto(Long id, String address) {

    @Builder
    public AddressResponseDto {
    }
}
