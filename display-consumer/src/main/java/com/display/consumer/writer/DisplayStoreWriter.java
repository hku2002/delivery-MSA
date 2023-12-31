package com.display.consumer.writer;

import com.display.consumer.domain.document.DisplayStore;
import com.display.consumer.domain.repository.mongo.DisplayStoreRepository;
import com.display.consumer.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DisplayStoreWriter {

    private final DisplayStoreRepository displayStoreRepository;

    public DisplayStore displayStoreWrite(MenuDto menuDto) {
        return displayStoreRepository.save(DisplayStore.from(menuDto));
    }

}
