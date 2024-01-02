package com.store.worker.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionListenDto {

    private Long optionId;
    private String optionName;
    private int optionPrice;

    @Builder
    public OptionListenDto(Long optionId, String optionName, int optionPrice) {
        this.optionId = optionId;
        this.optionName = optionName;
        this.optionPrice = optionPrice;
    }

}
