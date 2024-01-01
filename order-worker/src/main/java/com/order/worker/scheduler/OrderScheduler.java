package com.order.worker.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderScheduler {

    @Scheduled(fixedDelay = 10_000)
    public void createOrderCheckSchedule() {
        log.info("check success");
    }

}
