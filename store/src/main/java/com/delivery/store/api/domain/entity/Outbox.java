package com.delivery.store.api.domain.entity;

import com.delivery.store.api.domain.enumtype.Action;
import com.delivery.store.api.domain.enumtype.Operation;
import com.delivery.store.api.domain.enumtype.OutboxStatus;
import com.delivery.store.api.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Outbox extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long uniqueId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Action action;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Operation operation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OutboxStatus status;

    @Builder
    public Outbox(Long id, Long uniqueId, Action action, Operation operation, OutboxStatus status) {
        this.id = id;
        this.uniqueId = uniqueId;
        this.action = action;
        this.operation = operation;
        this.status = status;
    }

    public static Outbox of(Menu menu, Action action, Operation operation, OutboxStatus status) {
        return Outbox.builder()
                .uniqueId(menu.getId())
                .action(action)
                .operation(operation)
                .status(status)
                .build();
    }

    public static Outbox of(Option menu, Action action, Operation operation, OutboxStatus status) {
        return Outbox.builder()
                .uniqueId(menu.getId())
                .action(action)
                .operation(operation)
                .status(status)
                .build();
    }
}
