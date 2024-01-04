package com.order.worker.dto;

import com.order.worker.global.common.dto.BaseListenDto;
import com.order.worker.global.common.enumtype.Action;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderCompletedListenDto extends BaseListenDto {

    private final Long orderId;

    public OrderCompletedListenDto(Action action, LocalDateTime actionTime, Long orderId) {
        super(action, actionTime);
        this.orderId = orderId;
    }
}
