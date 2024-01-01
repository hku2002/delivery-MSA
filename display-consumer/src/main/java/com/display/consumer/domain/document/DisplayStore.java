package com.display.consumer.domain.document;

import com.display.consumer.dto.MenuDto;
import com.display.consumer.global.common.document.BaseDocument;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DisplayStore extends BaseDocument {

    @Id
    private Long id;
    private String name;
    private String thumbnailPath;
    private int starRating;
    private int deliveryFee;
    private List<Option> options;

    public static class Option extends BaseDocument {
        private Long id;
        private String name;
        private int price;

        @Builder
        public Option(Long id, String name, int price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public static Option from(MenuDto.OptionDto optionDto) {
            return Option.builder()
                    .id(optionDto.getId())
                    .name(optionDto.getName())
                    .price(optionDto.getPrice())
                    .build();
        }

        public static List<Option> from(MenuDto menuDto) {
            return menuDto.getOptions().stream()
                    .map(Option::from)
                    .toList();
        }
    }

    @Builder
    public DisplayStore(Long id, String name, String thumbnailPath, int starRating, int deliveryFee, List<Option> options) {
        this.id = id;
        this.name = name;
        this.thumbnailPath = thumbnailPath;
        this.starRating = starRating;
        this.deliveryFee = deliveryFee;
        this.options = options;
    }

    public static DisplayStore from(MenuDto menuDto) {
        return DisplayStore.builder()
                .id(menuDto.getId())
                .name(menuDto.getName())
                .thumbnailPath(menuDto.getThumbnailPath())
                .starRating(10)
                .deliveryFee(3000)
                .options(Option.from(menuDto))
                .build();
    }
}
