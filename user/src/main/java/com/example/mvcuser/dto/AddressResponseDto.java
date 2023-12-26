package com.example.mvcuser.dto;

import com.example.mvcuser.domain.entity.DeliveryAddress;
import lombok.Builder;

public record AddressResponseDto(Long id, String address) {

    @Builder
    public AddressResponseDto {
    }

    public static AddressResponseDto createInstance(DeliveryAddress deliveryAddress) {
        return AddressResponseDto.builder()
                .id(deliveryAddress.getId())
                .address(deliveryAddress.getAddress())
                .build();
    }

}
