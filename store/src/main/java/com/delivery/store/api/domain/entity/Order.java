package com.delivery.store.api.domain.entity;

import com.delivery.store.api.domain.enumtype.OrderStatus;
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

    @Column(nullable = false, length = 200)
    private String storeName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderStatus status;

    @Builder
    public Order(Long id, String name, int totalPrice, Long storeId, String storeName, OrderStatus status) {
        this.id = id;
        this.name = name;
        this.totalPrice = totalPrice;
        this.storeId = storeId;
        this.storeName = storeName;
        this.status = status;
    }

    public void changeOrderComplete() {
        if (this.status != OrderStatus.SENT) {
            throw new IllegalStateException();
        }
        this.status = OrderStatus.COMPLETED;
    }

}
