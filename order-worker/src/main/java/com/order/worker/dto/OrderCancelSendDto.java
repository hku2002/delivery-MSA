package com.order.worker.dto;

import com.order.worker.domain.entity.Order;
import com.order.worker.global.common.dto.BaseSendDto;
import com.order.worker.global.common.enumtype.Action;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderCancelSendDto extends BaseSendDto {

    private final List<Long> orderIds;

    public OrderCancelSendDto(List<Long> orderIds, Action action) {
        super(action);
        this.orderIds = orderIds;
    }

    public static OrderCancelSendDto from(List<Order> orders) {
        List<Long> orderIds = new ArrayList<>();
        orders.forEach(
                order -> orderIds.add(order.getId())
        );
        return new OrderCancelSendDto(orderIds, Action.REQUESTED_BY_USER);
    }

}
