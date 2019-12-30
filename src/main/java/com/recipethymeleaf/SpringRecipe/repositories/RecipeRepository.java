package com.recipethymeleaf.SpringRecipe.repositories;


import com.recipethymeleaf.SpringRecipe.domain.Category;
import com.recipethymeleaf.SpringRecipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
