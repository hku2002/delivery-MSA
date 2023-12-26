package com.delivery.store.api.controller;

import com.delivery.store.api.dto.AddMenuRequestDto;
import com.delivery.store.api.dto.AddMenuResponseDto;
import com.delivery.store.api.dto.AddOptionRequestDto;
import com.delivery.store.api.dto.AddOptionResponseDto;
import com.delivery.store.api.global.common.response.BaseResponse;
import com.delivery.store.api.global.common.response.CommonResponse;
import com.delivery.store.api.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/menu")
    public ResponseEntity<BaseResponse<AddMenuResponseDto>> addMenu(AddMenuRequestDto requestDto) {
        return CommonResponse.success(menuService.addMenu(requestDto));
    }

    @PostMapping("/menu/option")
    public ResponseEntity<BaseResponse<AddOptionResponseDto>> addOption(AddOptionRequestDto requestDto) {
        return CommonResponse.success(menuService.addOption(requestDto));
    }

}
