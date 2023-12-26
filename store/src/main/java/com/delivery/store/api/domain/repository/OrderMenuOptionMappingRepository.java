package com.delivery.store.api.domain.repository;

import com.delivery.store.api.domain.entity.OrderMenuOptionMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMenuOptionMappingRepository extends JpaRepository<OrderMenuOptionMapping, Long> {
}
