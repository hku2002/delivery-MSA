package com.order.api.service;

import com.order.api.domain.entity.Order;
import com.order.api.domain.entity.OrderMenu;
import com.order.api.domain.entity.OrderMenuOption;
import com.order.api.domain.repository.OrderMenuOptionRepository;
import com.order.api.domain.repository.OrderMenuRepository;
import com.order.api.domain.repository.OrderRepository;
import com.order.api.dto.OrderMenuOptionRequestDto;
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

    private final OrderRepository orderRepository;
    private final OrderMenuRepository orderMenuRepository;
    private final OrderMenuOptionRepository orderMenuOptionRepository;

    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        Order order = Order.from(requestDto);
        order.addTotalPrice(requestDto);
        order.addOrderName(requestDto);
        orderRepository.save(order);

        List<OrderMenu> orderMenuList = OrderMenu.from(requestDto.getOrderMenu());
        orderMenuRepository.saveAll(orderMenuList);

        List<OrderMenuOptionRequestDto> options = requestDto.getOrderMenu().stream()
                .flatMap(orderMenu -> orderMenu.getOptions().stream())
                .toList();
        List<OrderMenuOption> optionList = OrderMenuOption.from(options);
        orderMenuOptionRepository.saveAll(optionList);

        return new OrderResponseDto(order.getId());
    }

}
