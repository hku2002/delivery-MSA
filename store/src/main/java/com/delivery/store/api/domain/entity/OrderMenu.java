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
public class OrderMenu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Order order;

    @Column(nullable = false, length = 200)
    private String name;

    @Builder
    public OrderMenu(Long id, Order order, String name) {
        this.id = id;
        this.order = order;
        this.name = name;
    }
}
