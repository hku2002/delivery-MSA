package com.store.worker.dto;

import com.store.worker.domain.entity.Order;
import com.store.worker.global.common.dto.BaseSendDto;
import com.store.worker.global.common.enumtype.OrderAction;
import lombok.Getter;

@Getter
public class OrderCompletedSendDto extends BaseSendDto {

    private final Long orderId;

    public OrderCompletedSendDto(Long orderId, OrderAction action) {
        super(action);
        this.orderId = orderId;
    }

    public static OrderCompletedSendDto from(Order order) {
        return new OrderCompletedSendDto(order.getId(), OrderAction.COMPLETED_BY_STORE);
    }
}
