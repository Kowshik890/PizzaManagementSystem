package com.example.PizzaManagementSystem.service;

import com.example.PizzaManagementSystem.model.Pizza;
import com.example.PizzaManagementSystem.repository.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public Pizza addPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public Pizza findPizzaById(Long id) {
        return pizzaRepository.findPizzaById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Pizza by id " + id + "not found!"));
    }

    public Pizza updatePizza(Pizza pizza, Long id) {
        Pizza findOnePizza = findPizzaById(id);
        findOnePizza.setSize(pizza.getSize());
        findOnePizza.setPrice(pizza.getPrice());
        return pizzaRepository.save(findOnePizza);
    }
}
