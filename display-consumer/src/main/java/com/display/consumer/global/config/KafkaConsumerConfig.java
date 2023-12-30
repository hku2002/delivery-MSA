package com.display.consumer.global.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.key-deserializer}")
    private String keyDeserializer;

    @Value("${spring.kafka.value-deserializer}")
    private String valueDeserializer;

    @Bean("batchKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<Object, Object> batchKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(batchConsumerFactory());
        factory.setBatchListener(true);
        factory.setConcurrency(1);
        return factory;
    }

    public Map<String, Object> batchConsumerConfig() {
        return Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer,
                ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 150,
                ConsumerConfig.FETCH_MIN_BYTES_CONFIG, 512 * 1024,
                ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, 1000
        );
    }

    public ConsumerFactory<Object, Object> batchConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(batchConsumerConfig());
    }

}
