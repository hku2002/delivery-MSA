package com.display.consumer.global.common.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BaseListenDto {

    private final Character metaOperation;
    private final String metaTable;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public BaseListenDto(Character metaOperation, String metaTable, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.metaOperation = metaOperation;
        this.metaTable = metaTable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
