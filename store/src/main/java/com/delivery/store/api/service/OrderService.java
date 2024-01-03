package com.delivery.store.api.service;

import com.delivery.store.api.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public void changeOrderComplete(long id) {
        orderRepository.findById(id).orElseThrow().changeOrderComplete();
    }

}
