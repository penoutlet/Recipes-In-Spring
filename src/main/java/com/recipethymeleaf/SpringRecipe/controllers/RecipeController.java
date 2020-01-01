package com.recipethymeleaf.SpringRecipe.controllers;

import com.recipethymeleaf.SpringRecipe.domain.Recipe;
import com.recipethymeleaf.SpringRecipe.services.RecipeService;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        return "recipe/show";
    }

    @RequestMapping("/new")
    public String addRecipeForm(Model model) {

        model.addAttribute("recipe", new Recipe());

        return "recipe/addrecipeform";
    }

    @PostMapping("/add")
    public String saveOrUpdate(@ModelAttribute Recipe recipe) {
        recipeService.saveOrUpdate(recipe);
        return "redirect:/recipe/show/" + recipe.getId();

    }

    @GetMapping("/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/addrecipeform";
    }

    @GetMapping("{id}/delete")
    public String deleteRecipe(@PathVariable String id){
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/index";
    }
}

