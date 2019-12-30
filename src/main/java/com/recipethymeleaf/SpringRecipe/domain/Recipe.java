package com.recipethymeleaf.SpringRecipe.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    @Lob
    private Byte[] image;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Ingredient> ingredientSet;
    @ManyToMany /** ManyToMany will require a jointable*/
    @JoinTable(name="recipe_category", // names the jointable recipe_category... and each column of it to the column names below
    joinColumns = @JoinColumn(name="recipe_id"), inverseJoinColumns = @JoinColumn(name="category_id"))
    private Set<Category> categories;

    /** Use String values for the Enum
     * An enum is a field that tracks different
     * levels of a value -SJ */
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
}
