package com.store.worker.global.common.dto;

import com.store.worker.global.common.enumtype.OrderAction;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BaseSendDto {

    @Enumerated(EnumType.STRING)
    private final OrderAction action;
    private final LocalDateTime actionTime = LocalDateTime.now();

    public BaseSendDto(OrderAction orderAction) {
        this.action = orderAction;
    }
}
