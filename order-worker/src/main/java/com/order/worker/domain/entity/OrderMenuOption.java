package com.order.worker.domain.entity;

import com.order.worker.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

}
