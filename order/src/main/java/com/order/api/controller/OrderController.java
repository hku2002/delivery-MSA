package com.order.api.controller;

import com.order.api.dto.OrderRequestDto;
import com.order.api.dto.OrderResponseDto;
import com.order.api.global.common.response.BaseResponse;
import com.order.api.global.common.response.CommonResponse;
import com.order.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<BaseResponse<OrderResponseDto>> createOrder(OrderRequestDto requestDto) {
        return CommonResponse.success(orderService.createOrder(requestDto));
    }

}
