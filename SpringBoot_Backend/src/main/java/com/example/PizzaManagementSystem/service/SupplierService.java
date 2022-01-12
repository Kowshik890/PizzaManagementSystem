package com.example.PizzaManagementSystem.service;

import com.example.PizzaManagementSystem.model.Pizza;
import com.example.PizzaManagementSystem.model.Supplier;
import com.example.PizzaManagementSystem.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> findAllSupplier() {
        return supplierRepository.findAllSupplier();
    }

    public Supplier findSupplierById(Long id) {
        return supplierRepository.findSupplierById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Supplier by id " + id + "not found!"));
    }

    public Supplier updateSupplier(Supplier supplier, Long id) {
        Supplier findOneSupplier = findSupplierById(id);
        findOneSupplier.setName(supplier.getName());
        findOneSupplier.setIngredients(supplier.getIngredients());
        return supplierRepository.save(findOneSupplier);
    }

    public void deleteSupplierById(Long id) {
        supplierRepository.deleteSupplierById(id);
    }
}
