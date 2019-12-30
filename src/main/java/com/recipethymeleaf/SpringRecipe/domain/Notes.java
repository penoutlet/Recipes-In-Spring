package com.recipethymeleaf.SpringRecipe.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipes;
    @Lob /** allows large objects, larger than 250 characters */
    private String recipeNotes;
}
