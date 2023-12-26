package com.example.webfluxgateway.global.common.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

@Slf4j
public abstract class BaseClient {

    public static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            HttpMethod method = clientRequest.method();
            if (HttpMethod.GET.equals(method)) {
                log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
                return Mono.just(clientRequest);
            }

            log.info("Request: {} {} {}", clientRequest.method(), clientRequest.url(), clientRequest.body());
            return Mono.just(clientRequest);
        });
    }

    public static ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            log.info("Response Status: {} | uri: {}", clientResponse.statusCode(), clientResponse.request().getURI());
            return Mono.just(clientResponse);
        });
    }

}
