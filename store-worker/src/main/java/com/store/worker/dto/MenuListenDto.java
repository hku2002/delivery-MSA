package com.store.worker.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuListenDto {

    private Long menuId;
    private String menuName;
    private int menuPrice;
    private List<OptionListenDto> options;

    @Builder
    public MenuListenDto(Long menuId, String menuName, int menuPrice, List<OptionListenDto> options) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.options = options;
    }

}
