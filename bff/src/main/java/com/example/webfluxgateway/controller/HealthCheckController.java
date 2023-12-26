package com.example.webfluxgateway.controller;

import com.example.webfluxgateway.global.common.response.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HealthCheckController {

    @GetMapping("/ping")
    public Mono<BaseResponse<String>> checkPing() {
        return Mono.just(new BaseResponse<>("pong"));
    }

}
