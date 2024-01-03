package com.order.worker.dto;

import com.order.worker.domain.entity.OrderMenu;
import com.order.worker.domain.entity.OrderMenuOption;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class MenuSendDto {

    private Long menuId;
    private String menuName;
    private int menuPrice;
    private List<OptionSendDto> options;

    @Builder
    public MenuSendDto(Long menuId, String menuName, int menuPrice, List<OptionSendDto> options) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.options = options;
    }

    public static MenuSendDto from(OrderMenu orderMenu) {
        return MenuSendDto.builder()
                .menuId(orderMenu.getId())
                .menuName(orderMenu.getName())
                .menuPrice(orderMenu.getPrice())
                .options(OptionSendDto.from(orderMenu.getOrderMenuOptions()))
                .build();
    }

    public static List<MenuSendDto> from(List<OrderMenuOption> orderMenuOptions) {
        return orderMenuOptions.stream()
                .map(OrderMenuOption::getOrderMenu)
                .map(MenuSendDto::from)
                .toList();
    }
}
