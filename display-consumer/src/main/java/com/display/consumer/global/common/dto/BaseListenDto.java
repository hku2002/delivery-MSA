package com.display.consumer.global.common.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class BaseListenDto {

    private final Character metaOperation;
    private final String metaTable;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public BaseListenDto(Character metaOperation, String metaTable, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.metaOperation = metaOperation;
        this.metaTable = metaTable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static BaseListenDto from(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> recordMap = objectMapper.readValue(consumerRecord.value(), new TypeReference<>() {
        });

        Character metaOperation = String.valueOf(recordMap.get("meta_op")).charAt(0);
        String metaTable = String.valueOf(recordMap.get("meta_table"));
//        String createdAt = String.valueOf(recordMap.get("createdAt"));
//        String updatedAt = String.valueOf(recordMap.get("updatedAt"));

        return new BaseListenDto(metaOperation, metaTable, null, null);
    }
}
