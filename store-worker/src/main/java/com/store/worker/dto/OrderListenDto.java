package com.store.worker.dto;

import com.store.worker.domain.enumtype.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderListenDto {

    private Long orderId;
    private String orderName;
    private int totalPrice;
    private Long storeId;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private List<MenuListenDto> menus;


    @Builder
    public OrderListenDto(Long orderId, String orderName, int totalPrice, Long storeId, OrderStatus status, List<MenuListenDto> menus) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.totalPrice = totalPrice;
        this.storeId = storeId;
        this.status = status;
        this.menus = menus;
    }

}
