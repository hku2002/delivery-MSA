package com.store.worker.domain.entity;

import com.store.worker.domain.enumtype.OrderStatus;
import com.store.worker.dto.OrderListenDto;
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
    private int totalPrice;

    @Column(nullable = false)
    private Long storeId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderStatus status;

    @Builder
    public Order(Long id, String name, int totalPrice, Long storeId, OrderStatus status) {
        this.id = id;
        this.name = name;
        this.totalPrice = totalPrice;
        this.storeId = storeId;
        this.status = status;
    }

    public static Order from(OrderListenDto listenDto) {
        return Order.builder()
                .id(listenDto.getOrderId())
                .name(listenDto.getOrderName())
                .totalPrice(listenDto.getTotalPrice())
                .storeId(listenDto.getStoreId())
                .status(listenDto.getStatus())
                .build();
    }

}
