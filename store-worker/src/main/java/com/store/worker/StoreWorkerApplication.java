package com.store.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication
public class StoreWorkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreWorkerApplication.class, args);
    }

}
