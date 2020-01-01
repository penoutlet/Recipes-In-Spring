package com.recipethymeleaf.SpringRecipe.controllers;

import com.recipethymeleaf.SpringRecipe.domain.Category;
import com.recipethymeleaf.SpringRecipe.domain.UnitOfMeasure;
import com.recipethymeleaf.SpringRecipe.repositories.CategoryRepository;
import com.recipethymeleaf.SpringRecipe.repositories.UnitOfMeasureRepository;
import com.recipethymeleaf.SpringRecipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndex(Model model){
        // log.info("Inside controller");
        System.out.println(recipeService.getRecipes());
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }

}
