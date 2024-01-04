package com.store.worker.scheduler;

import com.store.worker.reader.OrderReader;
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
    public void orderCompletedCheckSchedule() {
        log.info("order completed check scheduler started");
        orderReader.readCompletedOrder();
    }

}
