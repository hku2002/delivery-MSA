package com.order.api.controller;

import com.order.api.dto.OrderRequestDto;
import com.order.api.dto.OrderResponseDto;
import com.order.api.global.common.response.BaseResponse;
import com.order.api.global.common.response.CommonResponse;
import com.order.api.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "orders", description = "주문 API")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<BaseResponse<OrderResponseDto>> createOrder(@RequestBody @Valid OrderRequestDto requestDto) {
        return CommonResponse.success(orderService.createOrder(requestDto));
    }

}
