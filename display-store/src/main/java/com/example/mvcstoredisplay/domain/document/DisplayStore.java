package com.example.mvcstoredisplay.domain.document;

import com.example.mvcstoredisplay.global.common.document.BaseDocument;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
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

    @Builder
    public DisplayStore(Long id, String name, String thumbnailPath, int starRating, int deliveryFee, List<Option> options) {
        this.id = id;
        this.name = name;
        this.thumbnailPath = thumbnailPath;
        this.starRating = starRating;
        this.deliveryFee = deliveryFee;
        this.options = options;
    }

    @Getter
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
    }
}
