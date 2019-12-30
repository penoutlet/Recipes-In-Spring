package com.recipethymeleaf.SpringRecipe.repositories;


import com.recipethymeleaf.SpringRecipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Category, Long> {
}
