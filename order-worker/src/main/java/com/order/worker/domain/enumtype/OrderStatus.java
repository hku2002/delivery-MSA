package com.order.worker.domain.enumtype;

import lombok.Getter;

@Getter
public enum OrderStatus {
    REQUEST,
    SENT,
    COMPLETED_BY_STORE,
    CANCELED_BY_STORE,
    CANCELED_BY_USER
}
