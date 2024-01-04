package com.order.worker.global.common.dto;

import com.order.worker.global.common.enumtype.Action;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BaseSendDto {

    @Enumerated(EnumType.STRING)
    private final Action action;
    private final LocalDateTime actionTime = LocalDateTime.now();

    public BaseSendDto(Action action) {
        this.action = action;
    }
}
