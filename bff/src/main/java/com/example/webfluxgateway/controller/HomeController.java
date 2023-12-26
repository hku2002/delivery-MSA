package com.example.webfluxgateway.controller;

import com.example.webfluxgateway.dto.HomeResponseDto;
import com.example.webfluxgateway.service.storedisplay.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/home/display/users/{userId}")
    public Mono<HomeResponseDto> getHomeItems(@PathVariable int userId) {
        return homeService.getDisplayStore(userId);
    }

}
