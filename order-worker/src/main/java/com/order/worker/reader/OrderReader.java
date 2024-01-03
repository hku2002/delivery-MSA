package com.order.worker.reader;

import com.order.worker.domain.entity.OrderMenuOption;
import com.order.worker.domain.enumtype.OrderStatus;
import com.order.worker.domain.repository.OrderMenuOptionRepository;
import com.order.worker.processor.OrderProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderReader {

    private final OrderMenuOptionRepository orderMenuOptionRepository;
    private final OrderProcessor orderProcessor;

    public void readRequestedOrder() {
        List<OrderMenuOption> orderMenuOptions = orderMenuOptionRepository.findAllByOrderStatus(OrderStatus.REQUEST);
        if (orderMenuOptions.isEmpty()) {
            log.info("orderEmpty");
            return;
        }
        orderProcessor.createOrderSendDto(orderMenuOptions);
    }

}
