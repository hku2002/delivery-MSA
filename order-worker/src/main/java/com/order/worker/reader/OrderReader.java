package com.order.worker.reader;

import com.order.worker.domain.entity.OrderMenuOption;
import com.order.worker.domain.enumtype.OrderStatus;
import com.order.worker.domain.repository.OrderMenuOptionRepository;
import com.order.worker.processor.OrderProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderReader {

    private final OrderMenuOptionRepository orderMenuOptionRepository;
    private final OrderProcessor orderProcessor;

    public List<OrderMenuOption> readRequestedOrder() {
        List<OrderMenuOption> orderMenuOptions = orderMenuOptionRepository.findAllByOrderStatus(OrderStatus.REQUEST);
        orderProcessor.createOrderSendDto(orderMenuOptions);
        return orderMenuOptions;
    }

}
