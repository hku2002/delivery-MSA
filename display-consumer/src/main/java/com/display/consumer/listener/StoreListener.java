package com.display.consumer.listener;

import com.display.consumer.domain.document.DisplayStore;
import com.display.consumer.domain.entity.Option;
import com.display.consumer.dto.MenuDto;
import com.display.consumer.dto.StoreListenDto;
import com.display.consumer.processor.StoreProcessor;
import com.display.consumer.reader.StoreReader;
import com.display.consumer.writer.DisplayStoreWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class StoreListener {

    private final StoreReader storeReader;
    private final StoreProcessor storeProcessor;
    private final DisplayStoreWriter displayStoreWriter;

    @KafkaListener(topics = "mysql.store.outbox", groupId = "display-group")
    public void consumeStoreOutboxTopic(String message) throws JsonProcessingException {
        log.info("message: {}", message);
        ObjectMapper objectMapper = new ObjectMapper();
        StoreListenDto storeListenDto = objectMapper.readValue(message, StoreListenDto.class);
        log.info("dto action: {}", storeListenDto.getAction());

        List<Option> options = storeReader.findMenu(storeListenDto.getUniqueId());
        MenuDto menuDto = storeProcessor.storeProcess(options);
        log.info("menuDto name: {}", menuDto.getName());

        DisplayStore writer = displayStoreWriter.displayStoreWrite(menuDto);
        log.info("writer name : {}", writer.getName());
    }

}
