package com.example.webfluxgateway.infra.client.storedisplay;

import com.example.webfluxgateway.dto.DisplayStoreResponseDto;
import com.example.webfluxgateway.global.common.client.BaseClient;
import com.example.webfluxgateway.global.common.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Slf4j
@Component
public class StoreDisplayClient extends BaseClient {

    private final WebClient webClient;
    private final ParameterizedTypeReference<BaseResponse<List<DisplayStoreResponseDto>>> displayStoreType = new ParameterizedTypeReference<>() {
    };

    public StoreDisplayClient(WebClient webClient) {
        this.webClient = webClient
                .mutate()
                .baseUrl("http://store-display-service:8080")
                .filter(logRequest())
                .filter(logResponse())
                .build();
    }

    public Mono<List<DisplayStoreResponseDto>> requestHomeStores() {
        return webClient.method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder.path("/display/stores")
                        .build())
                .retrieve()
                .bodyToMono(displayStoreType)
                .timeout(Duration.ofMillis(10000L))
                .mapNotNull(BaseResponse::getData);
    }

}
