package com.delivery.store.api.domain.repository;

import com.delivery.store.api.domain.entity.OrderMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMenuRepository extends JpaRepository<OrderMenu, Long> {
}
