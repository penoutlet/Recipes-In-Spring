package com.recipethymeleaf.SpringRecipe.bootstrap;

import com.recipethymeleaf.SpringRecipe.domain.Category;
import com.recipethymeleaf.SpringRecipe.domain.UnitOfMeasure;
import com.recipethymeleaf.SpringRecipe.repositories.CategoryRepository;
import com.recipethymeleaf.SpringRecipe.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DataInitializer(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
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


    }
}
