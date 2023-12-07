package com.example.finalprojectapteka.controllers;

import com.example.finalprojectapteka.models.Recipe;
import com.example.finalprojectapteka.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/recipe")
    public String recipeMain(Model model) {
        Iterable<Recipe> recipes = recipeRepository.findAll();
        model.addAttribute("recipes", recipes);
        return "recipe";
    }

    @GetMapping("/recipe/add")
    public String recipeAdd(@ModelAttribute("recipes") Recipe recipe) {
        return "recipe-add";
    }

    @PostMapping("/recipe/add")
    public String recipePostAdd(@ModelAttribute("recipes") @Valid Recipe recipe, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "recipe-add";
        }
        recipeRepository.save(recipe);
        return "redirect:/recipe";
    }

    @GetMapping("/recipe/{id}/edit")
    public  String recipeDetails(@PathVariable(value = "id") long id, Model model) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow();
        model.addAttribute("recipe", recipe);
        return "recipe-edit";
    }

    @PostMapping ("/recipe/{id}/edit")
    public  String recipeUpdate(@ModelAttribute("product") @Valid Recipe recipe,
                                 BindingResult bindingResult,
                                 @PathVariable(value = "id") long id)
    {
        if(bindingResult.hasErrors())
            return "recipe-edit";
        recipeRepository.save(recipe);
        return "redirect:/recipe";
    }

    @GetMapping("/recipe/{id}/remove")
    public  String recipeDelete(@PathVariable(value = "id") long id, Model model)
    {
        Recipe recipe = recipeRepository.findById(id).orElseThrow();
        recipeRepository.delete(recipe);
        return "redirect:/recipe";
    }
}
