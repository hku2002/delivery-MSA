package com.delivery.store.api.controller;

import com.delivery.store.api.global.common.response.BaseResponse;
import com.delivery.store.api.global.common.response.CommonResponse;
import com.delivery.store.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/{id}")
    public ResponseEntity<BaseResponse<String>> changeOrderComplete(@PathVariable long id) {
        orderService.changeOrderComplete(id);
        return CommonResponse.success("");
    }

}
