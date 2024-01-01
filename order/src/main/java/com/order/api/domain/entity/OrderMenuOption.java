package com.order.api.domain.entity;

import com.order.api.dto.OrderMenuOptionRequestDto;
import com.order.api.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

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
        this.addOrderMenu(orderMenu);
    }

    public static OrderMenuOption from(OrderMenuOptionRequestDto requestDto) {
        return OrderMenuOption.builder()
                .name(requestDto.getName())
                .price(requestDto.getPrice())
                .build();
    }

    public static List<OrderMenuOption> from(List<OrderMenuOptionRequestDto> requestDtos) {
        return requestDtos.stream()
                .map(OrderMenuOption::from)
                .toList();

    }

    public void addOrderMenu(OrderMenu orderMenu) {
        if (ObjectUtils.isEmpty(orderMenu)) {
            return;
        }
        this.orderMenu = orderMenu;
    }
}
