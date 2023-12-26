package com.example.mvcuser.controller;

import com.example.mvcuser.dto.AddressResponseDto;
import com.example.mvcuser.global.common.response.BaseResponse;
import com.example.mvcuser.global.common.response.CommonResponse;
import com.example.mvcuser.service.AddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Address", description = "Address API")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/user/address/{userId}")
    public ResponseEntity<BaseResponse<AddressResponseDto>> getAddress(@PathVariable Long userId) {
        return CommonResponse.success(addressService.getDefaultAddress(userId));
    }
}
