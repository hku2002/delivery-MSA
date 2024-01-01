package com.example.mvcstoredisplay.global.common.document;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class BaseDocument {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime LastSyncedAt;

}
