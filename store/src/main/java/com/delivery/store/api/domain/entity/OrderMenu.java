package com.delivery.store.api.domain.entity;

import com.delivery.store.api.global.common.entity.BaseEntity;
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

    @ManyToOne
    private Order order;

    private String name;

    @OneToMany
    private List<OrderMenuOptionMapping> orderMenuOptionMappings;


    @Builder
    public OrderMenu(Long id, Order order, String name, List<OrderMenuOptionMapping> orderMenuOptionMappings) {
        this.id = id;
        this.order = order;
        this.name = name;
        this.orderMenuOptionMappings = orderMenuOptionMappings;
    }
}
