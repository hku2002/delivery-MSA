package com.order.worker.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.worker.dto.OrderCompletedListenDto;
import com.order.worker.processor.OrderProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderListener {

    private final ObjectMapper objectMapper;
    private final OrderProcessor orderProcessor;

    @KafkaListener(topics = "order.inbound", groupId = "store-group")
    public void consumeOrderCompletedTopic(String message) throws JsonProcessingException {
        log.info("message: {}", message);
        OrderCompletedListenDto orderCompletedListenDto = objectMapper.readValue(message, OrderCompletedListenDto.class);
        log.info("orderId: {}", orderCompletedListenDto.getOrderId());
        Long orderId = orderProcessor.completeOrderProcess(orderCompletedListenDto);
        log.info("finished orderID: {}", orderId);
    }
}
