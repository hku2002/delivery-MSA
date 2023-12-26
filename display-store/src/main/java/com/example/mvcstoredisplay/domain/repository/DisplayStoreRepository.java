package com.example.mvcstoredisplay.domain.repository;

import com.example.mvcstoredisplay.domain.entity.DisplayStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisplayStoreRepository extends JpaRepository<DisplayStore, Long> {
}
