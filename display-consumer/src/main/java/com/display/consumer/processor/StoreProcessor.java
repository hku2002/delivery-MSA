package com.display.consumer.processor;

import com.display.consumer.dto.MenuDto;
import com.display.consumer.domain.entity.Menu;
import com.display.consumer.reader.StoreReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreProcessor {

    private final StoreReader storeReader;

    public MenuDto storeProcess(Menu menu) {
        return MenuDto.of(menu);
    }

}
