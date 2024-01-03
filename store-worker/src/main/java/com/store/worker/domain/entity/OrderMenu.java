package com.store.worker.domain.entity;

import com.store.worker.dto.MenuListenDto;
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
public class OrderMenu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private Order order;

    @Builder
    public OrderMenu(Long id, String name, int price, Order order) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.order = order;
    }

    public static OrderMenu of(MenuListenDto menuListenDto, OrderListenDto orderListenDto) {
        return OrderMenu.builder()
                .id(menuListenDto.getMenuId())
                .name(menuListenDto.getMenuName())
                .price(menuListenDto.getMenuPrice())
                .order(Order.from(orderListenDto))
                .build();
    }

    public static List<OrderMenu> from(OrderListenDto orderListenDto) {
        return orderListenDto.getMenus().stream()
                .map(menuListenDto -> OrderMenu.of(menuListenDto, orderListenDto))
                .toList();
    }

}
