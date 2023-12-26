package com.example.webfluxgateway.service.storedisplay;

import com.example.webfluxgateway.dto.AddressResponseDto;
import com.example.webfluxgateway.dto.DisplayStoreResponseDto;
import com.example.webfluxgateway.dto.HomeResponseDto;
import com.example.webfluxgateway.infra.client.storedisplay.StoreDisplayClient;
import com.example.webfluxgateway.infra.client.user.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final StoreDisplayClient storeDisplayClient;
    private final UserClient userClient;

    public Mono<HomeResponseDto> getDisplayStore(int userId) {
        return Mono.zip(
                userClient.requestAddress(userId),
                storeDisplayClient.requestHomeStores()
        ).flatMap(tuple -> {
                AddressResponseDto addressResponse = tuple.getT1();
                List<DisplayStoreResponseDto> storeDisplayResponse = tuple.getT2();

                return Mono.just(HomeResponseDto.builder()
                        .address(addressResponse)
                        .displayStores(storeDisplayResponse)
                        .build());
        });
    }

}
