package com.example.mvcstoredisplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DisplayStore {

    public static void main(String[] args) {
        SpringApplication.run(DisplayStore.class, args);
    }

}
