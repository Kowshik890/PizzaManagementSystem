package com.example.PizzaManagementSystem.controller;

import com.example.PizzaManagementSystem.model.Pizza;
import com.example.PizzaManagementSystem.model.Supplier;
import com.example.PizzaManagementSystem.repository.SupplierRepository;
import com.example.PizzaManagementSystem.service.PizzaService;
import com.example.PizzaManagementSystem.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin")
@AllArgsConstructor
public class AdminController {
    private final PizzaService pizzaService;
    private final SupplierService supplierService;

    // ============================================================================================

    // Pizza Functionalities
    @PostMapping("/pizza/add")
    public ResponseEntity<Pizza> addPizza(@RequestBody Pizza pizza) {
        Pizza newPizza = pizzaService.addPizza(pizza);
        return new ResponseEntity<>(newPizza, HttpStatus.CREATED);
    }

    @GetMapping("/pizza/all")
    public ResponseEntity<List<Pizza>> findAll() {
        List<Pizza> pizzaList = pizzaService.findAll();
        return new ResponseEntity<>(pizzaList, HttpStatus.OK);
    }

    @GetMapping("/pizza/find/{id}")
    public ResponseEntity<Pizza> findPizzaById(@PathVariable Long id) {
        Pizza pizza = pizzaService.findPizzaById(id);
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    @PutMapping("/pizza/update/{id}")
    public ResponseEntity<Pizza> updatePizza(@RequestBody Pizza pizza, @PathVariable Long id) {
        Pizza updatePizza = pizzaService.updatePizza(pizza, id);
        return new ResponseEntity<>(updatePizza, HttpStatus.OK);
    }

    // ============================================================================================

    // Supplier Functionalities
    @PostMapping("/supplier/add")
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier newSupplier = supplierService.addSupplier(supplier);
        return new ResponseEntity<>(newSupplier, HttpStatus.CREATED);
    }

    @GetMapping("/supplier/all")
    public ResponseEntity<List<Supplier>> findAllSupplier() {
        List<Supplier> supplierList = supplierService.findAllSupplier();
        return new ResponseEntity<>(supplierList, HttpStatus.OK);
    }

    @GetMapping("/supplier/find/{id}")
    public ResponseEntity<Supplier> findSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierService.findSupplierById(id);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @PutMapping("/supplier/update/{id}")
    public ResponseEntity<Supplier> updatePizza(@RequestBody Supplier supplier, @PathVariable Long id) {
        Supplier updateSupplier = supplierService.updateSupplier(supplier, id);
        return new ResponseEntity<>(updateSupplier, HttpStatus.OK);
    }

    @DeleteMapping("/supplier/delete/{id}")
    public ResponseEntity<?> deleteSupplierById(@PathVariable Long id) {
        supplierService.deleteSupplierById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Later
    // @PutMapping("/supplier/updateVisibility/{id}")

}
