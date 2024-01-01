package com.order.worker.domain.entity;

import com.order.worker.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "orderMenu", fetch = FetchType.LAZY)
    private List<OrderMenuOption> orderMenuOptions = new ArrayList<>();

    @Builder
    public OrderMenu(Long id, String name, int price, Order order, List<OrderMenuOption> orderMenuOptions) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.order = order;
        this.orderMenuOptions = orderMenuOptions;
    }

}
