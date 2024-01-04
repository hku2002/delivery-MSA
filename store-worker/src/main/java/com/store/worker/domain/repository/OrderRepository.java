package com.store.worker.domain.repository;

import com.store.worker.domain.entity.Order;
import com.store.worker.domain.enumtype.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findAllByStatus(OrderStatus status);

}
