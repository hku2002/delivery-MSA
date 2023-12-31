package com.display.consumer.domain.document;

import com.display.consumer.global.common.document.BaseDocument;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collation = "display_store")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class displayStore extends BaseDocument {

    @Id
    private Long id;
    private String name;
    private String thumbnailPath;
    private int starRating;
    private int deliveryFee;

}
