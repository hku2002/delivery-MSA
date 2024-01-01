package com.order.api.service;

import com.order.api.domain.entity.Order;
import com.order.api.domain.entity.OrderMenu;
import com.order.api.domain.repository.OrderMenuOptionRepository;
import com.order.api.dto.OrderRequestDto;
import com.order.api.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderMenuOptionRepository orderMenuOptionRepository;

    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        Order order = Order.from(requestDto);
        order.addTotalPrice(requestDto);
        order.addOrderName(requestDto);

        List<OrderMenu> orderMenuList = OrderMenu.of(requestDto.getOrderMenu(), order);
        orderMenuList.forEach(orderMenu -> {
            orderMenu.getOrderMenuOptions().forEach(orderMenuOption -> orderMenuOption.addOrderMenu(orderMenu));
            orderMenuOptionRepository.saveAll(orderMenu.getOrderMenuOptions());
        });

        return new OrderResponseDto(order.getId());
    }

}
