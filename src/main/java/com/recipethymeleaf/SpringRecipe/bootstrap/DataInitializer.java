package com.recipethymeleaf.SpringRecipe.bootstrap;

import com.recipethymeleaf.SpringRecipe.domain.Category;
import com.recipethymeleaf.SpringRecipe.domain.Ingredient;
import com.recipethymeleaf.SpringRecipe.domain.Recipe;
import com.recipethymeleaf.SpringRecipe.domain.UnitOfMeasure;
import com.recipethymeleaf.SpringRecipe.repositories.CategoryRepository;
import com.recipethymeleaf.SpringRecipe.repositories.RecipeRepository;
import com.recipethymeleaf.SpringRecipe.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public DataInitializer(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category c = new Category();
        c.setDescription("Vietnamese");

        // variable names in Java may start with letters, or the symbols _ and $
        Category _c1 = new Category();
        _c1.setDescription("American");

        categoryRepository.save(c);
        categoryRepository.save(_c1);
        UnitOfMeasure $tbs = new UnitOfMeasure();
        $tbs.setDescription("Tablespoon");

        unitOfMeasureRepository.save($tbs);

        Recipe r = new Recipe();
        r.setDescription("Yummy stuff");
        recipeRepository.save(r);

        Recipe r2 = new Recipe();
        r2.setDescription("Yummy stuff");
        r2.setCookTime(20);
        r2.setPrepTime(20);
        r2.setDirections("Cook a bit n eat it");

        Ingredient i1 = new Ingredient();
        i1.setDescription("I ama ingredient");
        Set<Ingredient> ingSet = new HashSet<>();
        ingSet.add(i1);
        r2.setIngredientSet(ingSet);
        recipeRepository.save(r2);

    }
}
