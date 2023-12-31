package com.order.worker.scheduler;

import com.order.worker.reader.OrderReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderScheduler {

    private final OrderReader orderReader;

    @Scheduled(fixedDelay = 10_000)
    public void createOrderCheckSchedule() {
        log.info("create order check scheduler started");
        orderReader.readRequestedOrder();
    }

    @Scheduled(fixedDelay = 10_000)
    public void cancelOrderCheckSchedule() {
        log.info("cancel order check scheduler started");
        orderReader.readCanceledOrder();
    }

}
