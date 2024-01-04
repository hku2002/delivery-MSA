package com.order.worker.processor;

import com.order.worker.domain.entity.Order;
import com.order.worker.domain.entity.OrderMenuOption;
import com.order.worker.dto.MenuSendDto;
import com.order.worker.dto.OptionSendDto;
import com.order.worker.dto.OrderCompletedListenDto;
import com.order.worker.dto.OrderSendDto;
import com.order.worker.sender.OrderSender;
import com.order.worker.writer.OrderWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderProcessor {

    private final OrderSender orderSender;
    private final OrderWriter orderWriter;

    public void createOrderSendDto(List<OrderMenuOption> orderMenuOptions) {
        List<OptionSendDto> options = OptionSendDto.from(orderMenuOptions);
        List<MenuSendDto> menus = MenuSendDto.from(orderMenuOptions);
        Order order = orderMenuOptions.get(0).getOrderMenu().getOrder();
        OrderSendDto orderSendDto = OrderSendDto.of(order, menus, options);
        orderSender.orderSend(orderSendDto);
    }

    public Long completeOrderProcess(OrderCompletedListenDto orderCompletedListenDto) {
        return orderWriter.changeOrderStatusCompleted(orderCompletedListenDto.getOrderId());
    }
}
