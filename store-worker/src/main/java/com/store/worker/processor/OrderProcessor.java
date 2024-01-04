package com.store.worker.processor;

import com.store.worker.domain.entity.Order;
import com.store.worker.domain.entity.OrderMenuOption;
import com.store.worker.dto.OrderCompletedSendDto;
import com.store.worker.dto.OrderListenDto;
import com.store.worker.sender.OrderSender;
import com.store.worker.writer.OrderWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProcessor {

    private final OrderWriter orderWriter;
    private final OrderSender orderSender;
    public Long createOrderProcess(OrderListenDto orderListenDto) {
        return orderWriter.createOrder(OrderMenuOption.from(orderListenDto));
    }

    public void createOrderCompletedSendDto(Order order) {
        orderSender.orderSend(OrderCompletedSendDto.from(order));
    }
}
