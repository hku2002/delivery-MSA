package com.example.mvcuser.domain.entity;

import com.example.mvcuser.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryAddress extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String address;

    @Column(nullable = false, length = 5)
    private String zipCode;

    @Column(nullable = false)
    private boolean isDefault;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @Builder
    public DeliveryAddress(Long id, String address, String zipCode, boolean isDefault, User user) {
        this.id = id;
        this.address = address;
        this.zipCode = zipCode;
        this.isDefault = isDefault;
        this.user = user;
    }
}
