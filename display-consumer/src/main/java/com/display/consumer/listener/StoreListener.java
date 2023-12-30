package com.display.consumer.listener;

import com.display.consumer.global.common.dto.BaseListenDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StoreListener {

    @KafkaListener(topics = "mysql.store.outbox", groupId = "display-group")
    public void consumeStoreOutboxTopic(ConsumerRecords<String, String> consumerRecords) throws JsonProcessingException {
        for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
            BaseListenDto listenDto = BaseListenDto.from(consumerRecord);
            log.info("ListenDto : {}", listenDto);
        }
    }

}
