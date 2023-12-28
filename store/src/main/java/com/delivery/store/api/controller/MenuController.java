package com.delivery.store.api.controller;

import com.delivery.store.api.dto.*;
import com.delivery.store.api.global.common.response.BaseResponse;
import com.delivery.store.api.global.common.response.CommonResponse;
import com.delivery.store.api.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/menu")
    public ResponseEntity<BaseResponse<List<GetMenuResponseDto>>> getMenu(GetMenuRequestDto requestDto) {
        return CommonResponse.success(menuService.getMenu(requestDto));
    }

}
