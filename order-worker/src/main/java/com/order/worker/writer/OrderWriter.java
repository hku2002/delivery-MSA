package com.order.worker.writer;

import com.order.worker.domain.entity.Order;
import com.order.worker.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class OrderWriter {

    private final OrderRepository orderRepository;

    public void changeOrderStatusSent(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.changStatusSent();
    }

    public void changeOrdersStatusSent(List<Long> orderIds) {
        List<Order> orders = orderRepository.findAllById(orderIds);
        orders.forEach(Order::changStatusSent);
    }

    public Long changeOrderStatusCompleted(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.changStatusCompleted();
        return order.getId();
    }
}
