package com.display.consumer.domain.document;

import com.display.consumer.dto.MenuDto;
import com.display.consumer.global.common.document.BaseDocument;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

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

    @Builder
    public DisplayStore(Long id, String name, String thumbnailPath, int starRating, int deliveryFee) {
        this.id = id;
        this.name = name;
        this.thumbnailPath = thumbnailPath;
        this.starRating = starRating;
        this.deliveryFee = deliveryFee;
    }

    public static DisplayStore from(MenuDto menuDto) {
        return DisplayStore.builder()
                .id(menuDto.getId())
                .name(menuDto.getName())
                .thumbnailPath(menuDto.getThumbnailPath())
                .starRating(10)
                .deliveryFee(3000)
                .build();
    }
}
