package com.recipethymeleaf.SpringRecipe.services;


import com.recipethymeleaf.SpringRecipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
