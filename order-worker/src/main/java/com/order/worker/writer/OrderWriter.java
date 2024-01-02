package com.order.worker.writer;

import com.order.worker.domain.entity.Order;
import com.order.worker.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OrderWriter {

    private final OrderRepository orderRepository;

    @Transactional
    public void changeOrderStatusSent(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.changStatusSent();
    }

}
