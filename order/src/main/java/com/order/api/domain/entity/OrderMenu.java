package com.order.api.domain.entity;

import com.order.api.dto.OrderMenuRequestDto;
import com.order.api.global.common.entity.BaseEntity;
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

    public static OrderMenu of(OrderMenuRequestDto requestDto, Order order) {
        return OrderMenu.builder()
                .name(requestDto.getName())
                .price(requestDto.getPrice())
                .order(order)
                .build();
    }

    public static List<OrderMenu> of(List<OrderMenuRequestDto> requestDtos, Order order) {
        return requestDtos.stream()
                .map(orderMenu -> OrderMenu.of(orderMenu, order))
                .toList();
    }
}
