package com.example.mvcuser.domain.repository;

import com.example.mvcuser.domain.entity.DeliveryAddress;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long> {

    @Query("SELECT da FROM DeliveryAddress da JOIN FETCH da.user u WHERE u.id = :userId AND da.isDefault = true")
    DeliveryAddress findFirstDeliveryAddress(Long userId, PageRequest pageRequest);

}
