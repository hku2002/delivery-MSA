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
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 300)
    private String thumbnailPath;

    @Column(nullable = false)
    private int deliveryFee;

    @Builder
    public Store(Long id, String name, String thumbnailPath, int deliveryFee) {
        this.id = id;
        this.name = name;
        this.thumbnailPath = thumbnailPath;
        this.deliveryFee = deliveryFee;
    }
}
