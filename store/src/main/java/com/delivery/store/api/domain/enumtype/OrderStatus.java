package com.delivery.store.api.domain.enumtype;

import lombok.Getter;

@Getter
public enum OrderStatus {
    REQUEST,
    SENT,
    COMPLETED,
    CANCELED_BY_STORE,
    CANCELED_BY_USER
}
