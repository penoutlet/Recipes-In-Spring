package com.recipethymeleaf.SpringRecipe.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER) // retrieve UoM each time retrieving an ingredient.
    private UnitOfMeasure unitOfMeasure;

    @ManyToOne // Ingredient has one recipe.
    private Recipe recipe;

}
