package com.order.api.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class OrderCancelRequestDto {

    @NotEmpty
    private Long orderId;

}
