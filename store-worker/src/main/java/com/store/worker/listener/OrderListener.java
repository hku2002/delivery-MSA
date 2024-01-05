package com.store.worker.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.worker.dto.OrderCancelListenDto;
import com.store.worker.dto.OrderListenDto;
import com.store.worker.global.common.enumtype.OrderAction;
import com.store.worker.processor.OrderProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@KafkaListener(topics = "order.outbound", groupId = "store-group")
public class OrderListener {

    private final ObjectMapper objectMapper;
    private final OrderProcessor orderProcessor;


    public void consumeOrderCreateTopic(String message) throws JsonProcessingException {
        log.info("message: {}", message);
        OrderListenDto orderListenDto = objectMapper.readValue(message, OrderListenDto.class);
        log.info("orderId: {}", orderListenDto.getOrderId());
        if (!OrderAction.REQUESTED_BY_USER.equals(orderListenDto.getAction())) {
            log.info("skip");
            return;
        }
        Long orderId = orderProcessor.createOrderProcess(orderListenDto);
        log.info("finished orderID: {}", orderId);
    }

    public void consumeOrderCancelTopic(String message) throws JsonProcessingException {
        log.info("message: {}", message);
        OrderCancelListenDto orderCancelListenDto = objectMapper.readValue(message, OrderCancelListenDto.class);
        log.info("orderIds: {}", orderCancelListenDto.getOrderIds());
        if (OrderAction.CANCELED_BY_USER.equals(orderCancelListenDto.getAction())) {
            log.info("cancel skip");
            return;
        }

        orderProcessor.cancelOrderProcess(orderCancelListenDto);
        //log.info("finished orderID: {}", orderId);
    }
}
