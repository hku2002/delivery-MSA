package com.store.worker.domain.repository;

import com.order.worker.domain.entity.OrderMenuOption;
import com.order.worker.domain.enumtype.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMenuOptionRepository extends JpaRepository<OrderMenuOption, Long> {

    @Query("SELECT omo FROM OrderMenuOption omo " +
            "JOIN FETCH omo.orderMenu om " +
            "JOIN FETCH om.order o " +
            "WHERE o.status = :status")
    List<OrderMenuOption> findAllByOrderStatus(OrderStatus status);

}
