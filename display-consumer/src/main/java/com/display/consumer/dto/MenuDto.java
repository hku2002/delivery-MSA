package com.display.consumer.dto;

import com.display.consumer.domain.entity.Menu;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuDto {

    private Long id;
    private String name;
    private String description;
    private String thumbnailPath;
    private int price;

    @Builder
    public MenuDto(Long id, String name, String description, String thumbnailPath, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnailPath = thumbnailPath;
        this.price = price;
    }

    public static MenuDto of(Menu menu) {
        return MenuDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .description(menu.getDescription())
                .thumbnailPath(menu.getThumbnailPath())
                .price(menu.getPrice())
                .build();
    }

}
