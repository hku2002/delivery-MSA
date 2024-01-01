package com.delivery.store.api.domain.repository;

import com.delivery.store.api.domain.entity.OrderMenuOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMenuOptionRepository extends JpaRepository<OrderMenuOption, Long> {
}
