package com.order.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderMenuRequestDto {

    @NotEmpty
    @Schema(description = "메뉴명", example = "파스타", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Min(100)
    @NotEmpty
    @Schema(description = "메뉴 가격", example = "7000", requiredMode = Schema.RequiredMode.REQUIRED)
    private int price;

    @Schema(description = "옵션", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private List<OrderMenuOptionRequestDto> options;

}
