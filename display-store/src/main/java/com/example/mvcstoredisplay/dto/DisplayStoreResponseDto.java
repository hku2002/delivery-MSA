package com.example.mvcstoredisplay.dto;

import com.example.mvcstoredisplay.domain.document.DisplayStore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DisplayStoreResponseDto {

    private Long id;
    private String name;
    private String thumbnailPath;
    private int starRating;
    private int deliveryFee;
    private List<OptionDto> options;

    @Builder
    public DisplayStoreResponseDto(Long id, String name, String thumbnailPath, int starRating, int deliveryFee, List<OptionDto> options) {
        this.id = id;
        this.name = name;
        this.thumbnailPath = thumbnailPath;
        this.starRating = starRating;
        this.deliveryFee = deliveryFee;
        this.options = options;
    }

    public static DisplayStoreResponseDto createInstance(DisplayStore store) {
        return DisplayStoreResponseDto.builder()
                .id(store.getId())
                .name(store.getName())
                .thumbnailPath(store.getThumbnailPath())
                .starRating(store.getStarRating())
                .deliveryFee(store.getDeliveryFee())
                .options(OptionDto.createInstance(store.getOptions()))
                .build();
    }

    public static List<DisplayStoreResponseDto> createInstance(List<DisplayStore> stores) {
        return stores.stream()
                .map(DisplayStoreResponseDto::createInstance)
                .collect(Collectors.toList());
    }

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

        public static OptionDto createInstance(DisplayStore.Option option) {
            return OptionDto.builder()
                    .id(option.getId())
                    .name(option.getName())
                    .price(option.getPrice())
                    .build();
        }

        public static List<OptionDto> createInstance(List<DisplayStore.Option> options) {
            if (ObjectUtils.isEmpty(options)) {
                return List.of(OptionDto.builder().build());
            }
            return options.stream()
                    .map(OptionDto::createInstance)
                    .toList();
        }

    }

}
