package com.example.PizzaManagementSystem.repository;

import com.example.PizzaManagementSystem.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Transactional
    @Modifying
    @Query("Select s from Supplier s order by id ASC")
    List<Supplier> findAllSupplier();

    Optional<Supplier> findSupplierById(Long id);

    void deleteSupplierById(Long id);
}
