package com.delivery.store.api.dto;

import com.delivery.store.api.domain.entity.Menu;
import lombok.Builder;

import java.util.List;

public class GetMenuResponseDto {

    private Long id;
    private String name;
    private String description;
    private String thumbnailPath;
    private int price;

    @Builder
    public GetMenuResponseDto(Long id, String name, String description, String thumbnailPath, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnailPath = thumbnailPath;
        this.price = price;
    }

    public static GetMenuResponseDto from(Menu menu) {
        return GetMenuResponseDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .description(menu.getDescription())
                .thumbnailPath(menu.getThumbnailPath())
                .price(menu.getPrice())
                .build();
    }

    public static List<GetMenuResponseDto> from(List<Menu> menus) {
        return menus.stream()
                .map(GetMenuResponseDto::from)
                .toList();
    }

}
