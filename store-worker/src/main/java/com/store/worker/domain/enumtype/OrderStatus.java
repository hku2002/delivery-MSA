package com.store.worker.domain.enumtype;

import lombok.Getter;

@Getter
public enum OrderStatus {
    REQUEST,
    COMPLETED,
    COMPLETED_SENT,
    CANCELED_BY_STORE,
    CANCELED_BY_USER
}
