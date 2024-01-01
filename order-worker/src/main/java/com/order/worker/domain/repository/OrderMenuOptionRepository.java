package com.order.worker.domain.repository;

import com.order.worker.domain.entity.OrderMenuOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMenuOptionRepository extends JpaRepository<OrderMenuOption, Long> {
}
