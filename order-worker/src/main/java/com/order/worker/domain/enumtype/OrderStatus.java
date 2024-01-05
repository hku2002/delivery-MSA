package com.order.worker.domain.enumtype;

import lombok.Getter;

@Getter
public enum OrderStatus {
    REQUEST,
    SENT_REQUEST,
    SENT_CANCEL,
    COMPLETED_BY_STORE,
    CANCELED_BY_STORE,
    CANCELED_BY_USER
}
