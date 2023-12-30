package com.display.consumer.reader;

import com.display.consumer.entity.Menu;
import com.display.consumer.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreReader {

    private final MenuRepository menuRepository;

    public Menu findMenu(Long uniqueId) {
        return menuRepository.findById(uniqueId).orElseThrow();
    }

}
