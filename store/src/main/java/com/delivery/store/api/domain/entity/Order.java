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

    private String orderName;

    private String userId;

    private String userName;

    private String userPhoneNumber;

    private int totalPrice;

    @Builder
    public Order(Long id, String orderName, String userId, String userName, String userPhoneNumber, int totalPrice) {
        this.id = id;
        this.orderName = orderName;
        this.userId = userId;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.totalPrice = totalPrice;
    }
}
