package com.example.mvcstoredisplay.dto;

import com.example.mvcstoredisplay.domain.entity.DisplayStore;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DisplayStoreResponseDto {

    private Long id;
    private String name;
    private String thumbnailPath;
    private int starRating;
    private int deliveryFee;

    @Builder
    public DisplayStoreResponseDto(Long id, String name, String thumbnailPath, int starRating, int deliveryFee) {
        this.id = id;
        this.name = name;
        this.thumbnailPath = thumbnailPath;
        this.starRating = starRating;
        this.deliveryFee = deliveryFee;
    }

    public static DisplayStoreResponseDto createInstance(DisplayStore store) {
        return DisplayStoreResponseDto.builder()
                .id(store.getId())
                .name(store.getName())
                .thumbnailPath(store.getThumbnailPath())
                .starRating(store.getStarRating())
                .deliveryFee(store.getDeliveryFee())
                .build();
    }

    public static List<DisplayStoreResponseDto> createInstance(List<DisplayStore> stores) {
        return stores.stream()
                .map(DisplayStoreResponseDto::createInstance)
                .collect(Collectors.toList());
    }

}
