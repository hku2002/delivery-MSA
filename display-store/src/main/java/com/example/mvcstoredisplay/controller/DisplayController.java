package com.example.mvcstoredisplay.controller;

import com.example.mvcstoredisplay.dto.DisplayStoreResponseDto;
import com.example.mvcstoredisplay.global.common.response.BaseResponse;
import com.example.mvcstoredisplay.global.common.response.CommonResponse;
import com.example.mvcstoredisplay.service.DisplayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Display", description = "Display store API")
public class DisplayController {

    private final DisplayService displayService;

    @GetMapping("/display/stores")
    public ResponseEntity<BaseResponse<List<DisplayStoreResponseDto>>> getStores() {
        return CommonResponse.success(displayService.getStores());
    }

}
