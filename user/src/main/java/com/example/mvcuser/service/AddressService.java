package com.example.mvcuser.service;

import com.example.mvcuser.domain.repository.DeliveryAddressRepository;
import com.example.mvcuser.dto.AddressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;

    public AddressResponseDto getDefaultAddress(Long userId) {
        return AddressResponseDto.createInstance(deliveryAddressRepository.findFirstDeliveryAddress(userId, PageRequest.of(0, 1)));
    }
}
