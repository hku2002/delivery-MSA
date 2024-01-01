package com.display.consumer.reader;

import com.display.consumer.domain.entity.Option;
import com.display.consumer.domain.repository.jpa.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreReader {

    private final OptionRepository optionRepository;

    public List<Option> findMenu(Long uniqueId) {
        return optionRepository.findAllOptionsWithMenu(uniqueId);
    }

}
