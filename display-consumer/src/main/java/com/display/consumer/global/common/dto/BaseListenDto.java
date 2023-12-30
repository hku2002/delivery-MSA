package com.display.consumer.global.common.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BaseListenDto {

    private Character metaOp;
    private String metaTable;
    private Long createdAt;
    private Long updatedAt;

    public BaseListenDto(Character metaOp, String metaTable, Long createdAt, Long updatedAt) {
        this.metaOp = metaOp;
        this.metaTable = metaTable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
