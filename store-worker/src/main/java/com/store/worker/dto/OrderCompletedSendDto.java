package com.store.worker.dto;

import com.store.worker.domain.entity.Order;
import lombok.Getter;

@Getter
public class OrderCompletedSendDto {

    private Long orderId;

    public OrderCompletedSendDto(Long orderId) {
        this.orderId = orderId;
    }

    public static OrderCompletedSendDto from(Order order) {
        return new OrderCompletedSendDto(order.getId());
    }
}
