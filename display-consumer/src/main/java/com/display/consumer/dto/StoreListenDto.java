package com.display.consumer.dto;

import com.display.consumer.domain.enumtype.Action;
import com.display.consumer.domain.enumtype.Operation;
import com.display.consumer.domain.enumtype.OutboxStatus;
import com.display.consumer.global.common.dto.BaseListenDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StoreListenDto extends BaseListenDto {

    private Long id;
    private Long uniqueId;
    @Enumerated(EnumType.STRING)
    private Action action;
    @Enumerated(EnumType.STRING)
    private Operation operation;
    @Enumerated(EnumType.STRING)
    private OutboxStatus status;

    @Builder
    public StoreListenDto(Character metaOperation, String metaTable, Long createdAt, Long updatedAt, Long id, Long uniqueId, Action action, Operation operation, OutboxStatus status) {
        super(metaOperation, metaTable, createdAt, updatedAt);
        this.id = id;
        this.uniqueId = uniqueId;
        this.action = action;
        this.operation = operation;
        this.status = status;
    }
}
