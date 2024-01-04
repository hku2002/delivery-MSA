package com.store.worker.global.common.dto;

import com.store.worker.global.common.enumtype.OrderAction;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BaseListenDto {

    @Enumerated(EnumType.STRING)
    private final OrderAction action;
    private final LocalDateTime actionTime;

    public BaseListenDto(OrderAction orderAction, LocalDateTime actionTime) {
        this.action = orderAction;
        this.actionTime = actionTime;
    }
}
