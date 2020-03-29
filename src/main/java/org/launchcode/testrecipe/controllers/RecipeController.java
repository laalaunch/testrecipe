package org.launchcode.testrecipe.controllers;

import org.launchcode.testrecipe.dao.RecipeDAO;
import org.launchcode.testrecipe.model.Recipe;
import org.launchcode.testrecipe.model.RecipeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Optional;

@Controller
@RequestMapping(value = "list")
public class RecipeController {

    @Autowired
    private RecipeDAO recipeDAO;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public RecipeController () {

        columnChoices.put("all", "All");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("recipes", recipeDAO.findAll());
        return "list";
    }

    @RequestMapping(value = "recipes")
    public String listRecipeByChoice(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Recipe> recipes;
        if (column.toLowerCase().equals("all")){
            recipes = recipeDAO.findAll();
            model.addAttribute("title", "All Recipes");
        } else {
            recipes = RecipeData.findByColumnAndValue(column, value, recipeDAO.findAll());
            model.addAttribute("title", "Recipe Choice " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("recipes", recipes);

        return "listRecipe";
    }

    @GetMapping("view/{recipeId}")
    public String displayViewRecipe(Model model, @PathVariable int recipeId){
        Optional optRecipe = recipeDAO.findById(recipeId);;
        if (optRecipe.isPresent()) {
            Recipe recipe = (Recipe) optRecipe.get();
            model.addAttribute("recipe", recipe);
            return "view";
        } else {
            return "redirect:../";
        }
    }
}
