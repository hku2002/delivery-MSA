package com.order.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
public class OrderMenuOptionRequestDto {

    @Schema(description = "메뉴 ID", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Long menuId;

    @Schema(description = "옵션명", example = "고수 추가", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String name;

    @Min(100)
    @Schema(description = "옵션 가격", example = "500", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private int price;
}
