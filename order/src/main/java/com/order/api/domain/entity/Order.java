package com.order.api.domain.entity;

import com.order.api.domain.enumtype.OrderStatus;
import com.order.api.dto.OrderMenuOptionRequestDto;
import com.order.api.dto.OrderMenuRequestDto;
import com.order.api.dto.OrderRequestDto;
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

    public static Order from(OrderRequestDto requestDto) {
        return Order.builder()
                .storeId(requestDto.getStoreId())
                .storeName(requestDto.getStoreName())
                .status(OrderStatus.REQUEST)
                .build();
    }

    public void addOrderName(OrderRequestDto requestDto) {
        int menuSize = requestDto.getOrderMenu().size();
        if (menuSize > 1) {
            this.name = requestDto.getOrderMenu().get(0).getName() + " 외 " + menuSize;
            return;
        }
        this.name = requestDto.getOrderMenu().get(0).getName();
    }

    public void addTotalPrice(OrderRequestDto requestDto) {
        int optionTotalPrice = requestDto.getOrderMenu().stream()
                .flatMap(orderMenu -> orderMenu.getOptions().stream())
                .mapToInt(OrderMenuOptionRequestDto::getPrice)
                .sum();

        int menuTotalPrice = requestDto.getOrderMenu().stream()
                .mapToInt(OrderMenuRequestDto::getPrice)
                .sum();

        this.totalPrice = optionTotalPrice + menuTotalPrice;
    }
}
