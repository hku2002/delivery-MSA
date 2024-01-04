package com.store.worker.dto;

import com.store.worker.domain.enumtype.OrderStatus;
import com.store.worker.global.common.dto.BaseListenDto;
import com.store.worker.global.common.enumtype.OrderAction;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderListenDto extends BaseListenDto {

    private Long orderId;
    private String orderName;
    private int totalPrice;
    private Long storeId;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private List<MenuListenDto> menus;


    @Builder
    public OrderListenDto(Long orderId, String orderName, int totalPrice, Long storeId, OrderStatus status, List<MenuListenDto> menus, OrderAction orderAction, LocalDateTime actionTime) {
        super(orderAction, actionTime);
        this.orderId = orderId;
        this.orderName = orderName;
        this.totalPrice = totalPrice;
        this.storeId = storeId;
        this.status = status;
        this.menus = menus;
    }

}
