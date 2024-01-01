package com.order.worker.sender;

import com.order.worker.dto.OrderSendDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderSender {

    private final KafkaTemplate<String, OrderSendDto> kafkaTemplate;
    private static final String ORDER_CREATE_TOPIC_NAME = "order.create";

    public void orderSend(OrderSendDto sendDto) {
//        CompletableFuture<SendResult<String, OrderSendDto>> future = kafkaTemplate.send(ORDER_CREATE_TOPIC_NAME, sendDto);
//        future.whenComplete((result, ex) -> {
//            if (ex == null) {
//                log.info("order.create message send success!");
//            }
//            else {
//                log.error("order.create message send fail!");
//            }
//        });
    }
}
