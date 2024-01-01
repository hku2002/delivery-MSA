package com.display.consumer.dto;

import com.display.consumer.domain.entity.Menu;
import com.display.consumer.domain.entity.Option;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuDto {

    private Long id;
    private String name;
    private String description;
    private String thumbnailPath;
    private int price;
    private List<OptionDto> options;

    @Getter
    public static class OptionDto {
        private Long id;
        private String name;
        private int price;

        @Builder
        public OptionDto(Long id, String name, int price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public static OptionDto from(Option option) {
            return OptionDto.builder()
                    .id(option.getId())
                    .name(option.getName())
                    .price(option.getPrice())
                    .build();
        }

        public static List<OptionDto> from(List<Option> options) {
            return options.stream()
                    .map(OptionDto::from)
                    .toList();
        }

    }

    @Builder
    public MenuDto(Long id, String name, String description, String thumbnailPath, int price, List<OptionDto> options) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnailPath = thumbnailPath;
        this.price = price;
        this.options = options;
    }

    public static MenuDto of(Menu menu, List<Option> options) {
        return MenuDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .description(menu.getDescription())
                .thumbnailPath(menu.getThumbnailPath())
                .price(menu.getPrice())
                .options(OptionDto.from(options))
                .build();
    }

}
