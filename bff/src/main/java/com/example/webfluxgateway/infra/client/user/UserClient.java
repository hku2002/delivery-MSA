package com.example.webfluxgateway.infra.client.user;

import com.example.webfluxgateway.dto.AddressResponseDto;
import com.example.webfluxgateway.global.common.client.BaseClient;
import com.example.webfluxgateway.global.common.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@Component
public class UserClient extends BaseClient {

    private final WebClient webClient;
    private final ParameterizedTypeReference<BaseResponse<AddressResponseDto>> addressResponseType = new ParameterizedTypeReference<>() {
    };

    public UserClient(WebClient webClient) {
        this.webClient = webClient
                .mutate()
                .baseUrl("http://user-service:8090")
                .filter(logRequest())
                .filter(logResponse())
                .build();
    }

    public Mono<AddressResponseDto> requestAddress(int userId) {
        return webClient.method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder.path("/user/address/" + userId)
                        .build())
                .retrieve()
                .bodyToMono(addressResponseType)
                .timeout(Duration.ofMillis(10000L))
                .mapNotNull(BaseResponse::getData);
    }

}
