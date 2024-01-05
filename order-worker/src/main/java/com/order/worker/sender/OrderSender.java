package com.order.worker.sender;

import com.order.worker.dto.OrderCancelSendDto;
import com.order.worker.dto.OrderSendDto;
import com.order.worker.writer.OrderWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderSender {

    private final KafkaTemplate<String, OrderSendDto> orderCreateTemplate;
    private final KafkaTemplate<String, OrderCancelSendDto> orderCancelTemplate;
    private final OrderWriter orderWriter;
    private static final String ORDER_CREATE_TOPIC_NAME = "order.outbound";

    @Transactional
    public void orderSend(OrderSendDto sendDto) {
        CompletableFuture<SendResult<String, OrderSendDto>> future = orderCreateTemplate.send(ORDER_CREATE_TOPIC_NAME, sendDto);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("order create message send success!");
                orderWriter.changeOrderStatusSent(sendDto.getOrderId());
            } else {
                log.error("order create message send fail!");
            }
        });
    }

    public void orderCancelSend(OrderCancelSendDto cancelSendDto) {
        CompletableFuture<SendResult<String, OrderCancelSendDto>> future = orderCancelTemplate.send(ORDER_CREATE_TOPIC_NAME, cancelSendDto);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                orderWriter.changeOrdersStatusSent(cancelSendDto.getOrderIds());
                log.info("order cancel message send success!");
            } else {
                log.error("order cancel message send fail!");
            }
        });
    }
}
