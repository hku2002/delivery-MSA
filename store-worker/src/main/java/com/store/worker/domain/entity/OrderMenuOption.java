package com.store.worker.domain.entity;

import com.store.worker.dto.MenuListenDto;
import com.store.worker.dto.OptionListenDto;
import com.store.worker.dto.OrderListenDto;
import com.store.worker.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderMenuOption extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private int price;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private OrderMenu orderMenu;

    @Builder
    public OrderMenuOption(Long id, String name, int price, OrderMenu orderMenu) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orderMenu = orderMenu;
    }

    public static OrderMenuOption of(OptionListenDto optionListenDto, MenuListenDto menuListenDto, OrderListenDto orderListenDto) {
        return OrderMenuOption.builder()
                .id(optionListenDto.getOptionId())
                .name(optionListenDto.getOptionName())
                .price(optionListenDto.getOptionPrice())
                .orderMenu(OrderMenu.of(menuListenDto,orderListenDto))
                .build();
    }

    public static List<OrderMenuOption> from(OrderListenDto orderListenDto) {
        return orderListenDto.getMenus().stream()
                .flatMap(menuListenDto -> menuListenDto.getOptions().stream()
                        .map(optionListenDto -> OrderMenuOption.of(optionListenDto, menuListenDto, orderListenDto)))
                .toList();
    }

}
