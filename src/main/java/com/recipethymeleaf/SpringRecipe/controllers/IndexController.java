package com.recipethymeleaf.SpringRecipe.controllers;

import com.recipethymeleaf.SpringRecipe.domain.Category;
import com.recipethymeleaf.SpringRecipe.domain.UnitOfMeasure;
import com.recipethymeleaf.SpringRecipe.repositories.CategoryRepository;
import com.recipethymeleaf.SpringRecipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Component
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndex(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Description ID is: " + categoryOptional.get().getId());
        System.out.println("Unit ID of measure: " + unitOfMeasureOptional.get().getId());
        return "index";
    }

}
