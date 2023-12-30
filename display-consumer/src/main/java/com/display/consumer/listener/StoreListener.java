package com.display.consumer.listener;

import com.display.consumer.dto.StoreListenDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StoreListener {

    @KafkaListener(topics = "mysql.store.outbox", groupId = "display-group")
    public void consumeStoreOutboxTopic(String message) throws JsonProcessingException {
        log.info("message: {}", message);
        ObjectMapper objectMapper = new ObjectMapper();
        StoreListenDto storeListenDto = objectMapper.readValue(message, StoreListenDto.class);
        log.info("dto action: {}", storeListenDto.getAction());
        log.info("dto action: {}", storeListenDto.getCreatedAt());
    }

}
