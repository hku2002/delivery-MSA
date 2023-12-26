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
public class OrderMenuOptionMapping extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private OrderMenu orderMenu;

    @OneToMany
    private List<Option> options;

    @Builder
    public OrderMenuOptionMapping(Long id, OrderMenu orderMenu, List<Option> options) {
        this.id = id;
        this.orderMenu = orderMenu;
        this.options = options;
    }
}
