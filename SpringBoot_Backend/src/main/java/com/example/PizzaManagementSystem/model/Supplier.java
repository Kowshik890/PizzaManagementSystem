package com.example.PizzaManagementSystem.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode      // This annotation is used to override the equals() and hashCode() methods
@NoArgsConstructor      // This annotation is used to generate a constructor with no arguments
@AllArgsConstructor     // This annotation is used to generate a parameterized constructor which -
                        // - accepts a single parameter for each field and initializes them using it
@ToString               // This annotation is used to override the toString() method and generate a default implementation for it
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String ingredients;
    private boolean isHidden;
}
