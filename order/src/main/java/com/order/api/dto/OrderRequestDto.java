package com.order.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Schema(description = "주문 요청 DTO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderRequestDto {

    @Min(1)
    @NotEmpty
    @Schema(description = "가게 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long storeId;

    @NotEmpty
    @Schema(description = "가게 명", example = "맛있는 파스타", requiredMode = Schema.RequiredMode.REQUIRED)
    private String storeName;

    @Schema(description = "가게 메뉴", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<OrderMenuRequestDto> orderMenu;

}
