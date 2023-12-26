package com.delivery.store.api.domain.entity;

import com.delivery.store.api.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String orderName;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false, length = 30)
    private String userName;

    @Column(nullable = false, length = 11)
    private String userPhoneNumber;

    @Column(nullable = false)
    private int totalPrice;

    @Builder
    public Order(Long id, String orderName, Long userId, String userName, String userPhoneNumber, int totalPrice) {
        this.id = id;
        this.orderName = orderName;
        this.userId = userId;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.totalPrice = totalPrice;
    }
}
