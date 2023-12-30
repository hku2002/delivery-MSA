package com.display.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DisplayConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisplayConsumerApplication.class, args);
    }

}
