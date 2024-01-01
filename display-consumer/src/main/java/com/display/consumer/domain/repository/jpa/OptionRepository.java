package com.display.consumer.domain.repository.jpa;

import com.display.consumer.domain.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    @Query("SELECT DISTINCT o FROM Option o LEFT JOIN FETCH o.menu m WHERE m.id = :menuId")
    List<Option> findAllOptionsWithMenu(Long menuId);
}
