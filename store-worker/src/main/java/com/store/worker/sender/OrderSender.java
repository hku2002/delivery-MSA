package com.store.worker.sender;

import com.store.worker.dto.OrderCompletedSendDto;
import com.store.worker.writer.OrderWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderSender {

    private final KafkaTemplate<String, OrderCompletedSendDto> kafkaTemplate;
    private final OrderWriter orderWriter;
    private static final String ORDER_COMPLETED_TOPIC_NAME = "order.completed";

    public void orderSend(OrderCompletedSendDto orderCompletedSendDto) {
        CompletableFuture<SendResult<String, OrderCompletedSendDto>> future = kafkaTemplate.send(ORDER_COMPLETED_TOPIC_NAME, orderCompletedSendDto);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("order.create message send success!");
                orderWriter.completedSentOrder(orderCompletedSendDto);
            } else {
                log.error("order.create message send fail!");
            }
        });
    }
}
