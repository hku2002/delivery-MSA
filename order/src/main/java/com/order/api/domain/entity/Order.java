package com.order.api.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String totalPrice;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private String storeName;

    @Builder
    public Order(Long id, String name, String totalPrice, Long storeId, String storeName) {
        this.id = id;
        this.name = name;
        this.totalPrice = totalPrice;
        this.storeId = storeId;
        this.storeName = storeName;
    }
}
