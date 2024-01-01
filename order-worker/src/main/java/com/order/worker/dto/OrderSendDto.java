package com.order.worker.dto;

import com.order.worker.domain.enumtype.OrderStatus;
import lombok.Getter;

@Getter
public class OrderSendDto {

    private Long orderId;
    private String orderName;
    private int totalPrice;
    private Long storeId;
    private OrderStatus status;

}
