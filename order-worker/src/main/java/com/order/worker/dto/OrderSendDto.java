package com.order.worker.dto;

import com.order.worker.domain.entity.Order;
import com.order.worker.domain.enumtype.OrderStatus;
import com.order.worker.global.common.dto.BaseSendDto;
import com.order.worker.global.common.enumtype.Action;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderSendDto extends BaseSendDto {

    private Long orderId;
    private String orderName;
    private int totalPrice;
    private Long storeId;
    private OrderStatus status;
    private List<MenuSendDto> menus;

    @Builder
    public OrderSendDto(Long orderId, String orderName, int totalPrice, Long storeId, OrderStatus status, List<MenuSendDto> menus, Action action) {
        super(action);
        this.orderId = orderId;
        this.orderName = orderName;
        this.totalPrice = totalPrice;
        this.storeId = storeId;
        this.status = status;
        this.menus = menus;
    }

    public static OrderSendDto of(Order order, List<MenuSendDto> menus, List<OptionSendDto> options) {
        return OrderSendDto.builder()
                .orderId(order.getId())
                .orderName(order.getName())
                .totalPrice(order.getTotalPrice())
                .storeId(order.getStoreId())
                .status(order.getStatus())
                .menus(menus)
                .action(Action.REQUESTED_BY_USER)
                .build();
    }
}
