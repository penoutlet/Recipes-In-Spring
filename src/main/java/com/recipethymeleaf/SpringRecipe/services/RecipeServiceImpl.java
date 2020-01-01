package com.recipethymeleaf.SpringRecipe.services;

import com.recipethymeleaf.SpringRecipe.domain.Recipe;
import com.recipethymeleaf.SpringRecipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        // log.info("In the service");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long l){
        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

        if (!recipeOptional.isPresent()) {
            throw new RuntimeException(("Recipe Not Found!!!"));
        }

        return recipeOptional.get();
    }

  
    public void saveOrUpdate(Recipe recipe){
        
        recipeRepository.save(recipe);
    }

    public Long deleteById(Long id){
        recipeRepository.deleteById(id);
        return id;
    }
}

