package com.display.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StoreListener {

    @KafkaListener(topics = "mysql.store.outbox", groupId = "display-group")
    public void consumeStoreOutboxTopic(String message) {
        log.info("message: {}", message);
    }

}
