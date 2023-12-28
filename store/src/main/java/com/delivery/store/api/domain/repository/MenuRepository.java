package com.delivery.store.api.domain.repository;

import com.delivery.store.api.domain.entity.Menu;
import com.delivery.store.api.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findAllByStore(Store store);
}
