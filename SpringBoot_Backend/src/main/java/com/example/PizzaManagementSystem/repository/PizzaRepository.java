package com.example.PizzaManagementSystem.repository;

import com.example.PizzaManagementSystem.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    @Transactional
    @Modifying
    @Query("Select p from Pizza p order by id ASC")
    List<Pizza> findAll();
    Optional<Pizza> findPizzaById(Long id);
}
