package com.store.worker.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.worker.dto.OrderListenDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderListener {

    @KafkaListener(topics = "order.create", groupId = "store-group")
    public void consumeOrderCreateTopic(String message) throws JsonProcessingException {
        log.info("message: {}", message);
        ObjectMapper objectMapper = new ObjectMapper();
        OrderListenDto storeListenDto = objectMapper.readValue(message, OrderListenDto.class);
        log.info("orderId: {}", storeListenDto.getOrderId());
    }
}
