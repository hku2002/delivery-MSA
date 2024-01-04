package com.store.worker.writer;

import com.store.worker.domain.entity.Order;
import com.store.worker.domain.entity.OrderMenuOption;
import com.store.worker.domain.repository.OrderMenuOptionRepository;
import com.store.worker.domain.repository.OrderMenuRepository;
import com.store.worker.domain.repository.OrderRepository;
import com.store.worker.dto.OrderCompletedSendDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class OrderWriter {

    private final OrderRepository orderRepository;
    private final OrderMenuRepository orderMenuRepository;
    private final OrderMenuOptionRepository orderMenuOptionRepository;

    public Long createOrder(List<OrderMenuOption> orderMenuOptions) {
        Order order = orderRepository.save(orderMenuOptions.get(0).getOrderMenu().getOrder());
        orderMenuRepository.save(orderMenuOptions.get(0).getOrderMenu());
        orderMenuOptionRepository.saveAll(orderMenuOptions);
        return order.getId();
    }

    public void completedSentOrder(OrderCompletedSendDto orderCompletedSendDto) {
        Order order = orderRepository.findById(orderCompletedSendDto.getOrderId()).orElseThrow();
        order.changeCompletedSent();
    }


}
