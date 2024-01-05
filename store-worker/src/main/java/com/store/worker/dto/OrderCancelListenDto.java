package com.store.worker.dto;

import com.store.worker.global.common.dto.BaseListenDto;
import com.store.worker.global.common.enumtype.OrderAction;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderCancelListenDto extends BaseListenDto {

    private final List<Long> orderIds;

    public OrderCancelListenDto(List<Long> orderIds, OrderAction orderAction, LocalDateTime localDateTime) {
        super(orderAction, localDateTime);
        this.orderIds = orderIds;
    }
}
