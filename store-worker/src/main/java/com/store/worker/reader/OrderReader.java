package com.store.worker.reader;

import com.store.worker.domain.entity.Order;
import com.store.worker.domain.enumtype.OrderStatus;
import com.store.worker.domain.repository.OrderRepository;
import com.store.worker.processor.OrderProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Slf4j
@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderReader {

    private final OrderRepository orderRepository;
    private final OrderProcessor orderProcessor;

    public void readCompletedOrder() {
        Order order = orderRepository.findAllByStatus(OrderStatus.COMPLETED);
        if (ObjectUtils.isEmpty(order)) {
            log.info("orderEmpty");
            return;
        }
        orderProcessor.createOrderCompletedSendDto(order);
    }

}
