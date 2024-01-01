package com.order.worker.dto;

import com.order.worker.domain.entity.OrderMenuOption;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class OptionSendDto {

    private Long optionId;
    private String optionName;
    private int optionPrice;

    @Builder
    public OptionSendDto(Long optionId, String optionName, int optionPrice) {
        this.optionId = optionId;
        this.optionName = optionName;
        this.optionPrice = optionPrice;
    }

    public static OptionSendDto from(OrderMenuOption orderMenuOption) {
        return OptionSendDto.builder()
                .optionId(orderMenuOption.getId())
                .optionName(orderMenuOption.getName())
                .optionPrice(orderMenuOption.getPrice())
                .build();
    }

    public static List<OptionSendDto> from(List<OrderMenuOption> orderMenuOptions) {
        return orderMenuOptions.stream()
                .map(OptionSendDto::from)
                .toList();
    }
}
