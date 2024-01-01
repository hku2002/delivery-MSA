package com.display.consumer.processor;

import com.display.consumer.domain.entity.Option;
import com.display.consumer.dto.MenuDto;
import com.display.consumer.reader.StoreReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreProcessor {

    private final StoreReader storeReader;

    public MenuDto storeProcess(List<Option> options) {
        return MenuDto.of(options.get(0).getMenu(), options);
    }

}
