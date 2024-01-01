package com.order.api.domain.entity;

import com.order.api.global.common.entity.BaseEntity;
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

    @Column(nullable = false, length = 200)
    private String name;

    @Column(length = 400)
    private String description;

    @Column(nullable = false, length = 300)
    private String thumbnailPath;

    @Column(nullable = false)
    private int price;

    @Builder
    public OrderMenu(Long id, String name, String description, String thumbnailPath, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnailPath = thumbnailPath;
        this.price = price;
    }
}
