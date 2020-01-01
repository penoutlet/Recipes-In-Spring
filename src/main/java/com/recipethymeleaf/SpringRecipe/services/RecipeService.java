package com.recipethymeleaf.SpringRecipe.services;


import com.recipethymeleaf.SpringRecipe.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    void saveOrUpdate(Recipe recipe);
    Long deleteById(Long id);

}
