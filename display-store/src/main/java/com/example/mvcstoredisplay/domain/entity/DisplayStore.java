package com.example.mvcstoredisplay.domain.entity;

import com.example.mvcstoredisplay.global.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DisplayStore extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String thumbnailPath;
    private int starRating;
    private int deliveryFee;

    @Builder
    public DisplayStore(Long id, String name, String thumbnailPath, int starRating, int deliveryFee) {
        this.id = id;
        this.name = name;
        this.thumbnailPath = thumbnailPath;
        this.starRating = starRating;
        this.deliveryFee = deliveryFee;
    }
}
