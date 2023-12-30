package com.display.consumer.dto;

import com.display.consumer.entity.enumtype.Action;
import com.display.consumer.entity.enumtype.Operation;
import com.display.consumer.entity.enumtype.OutboxStatus;
import com.display.consumer.global.common.dto.BaseListenDto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class StoreListenDto extends BaseListenDto {

    private final Long id;
    private final Long uniqueId;
    @Enumerated(EnumType.STRING)
    private final Action action;
    @Enumerated(EnumType.STRING)
    private final Operation operation;
    @Enumerated(EnumType.STRING)
    private final OutboxStatus status;

    @Builder
    public StoreListenDto(Character metaOperation, String metaTable, LocalDateTime createdAt, LocalDateTime updatedAt, Long id, Long uniqueId, Action action, Operation operation, OutboxStatus status) {
        super(metaOperation, metaTable, createdAt, updatedAt);
        this.id = id;
        this.uniqueId = uniqueId;
        this.action = action;
        this.operation = operation;
        this.status = status;
    }
}
