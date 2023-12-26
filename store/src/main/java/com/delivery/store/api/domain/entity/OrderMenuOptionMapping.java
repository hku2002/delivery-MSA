package com.delivery.store.api.domain.entity;

import com.delivery.store.api.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderMenuOptionMapping extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private OrderMenu orderMenu;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private Option option;

    @Builder
    public OrderMenuOptionMapping(Long id, OrderMenu orderMenu, Option option) {
        this.id = id;
        this.orderMenu = orderMenu;
        this.option = option;
    }
}
