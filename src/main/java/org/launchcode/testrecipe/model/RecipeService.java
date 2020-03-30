package org.launchcode.testrecipe.model;

import org.launchcode.testrecipe.dao.RecipeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeDAO recipeDAO;

    public List<Recipe> getAllRecipe() {
        List<Recipe> allRecipe = new ArrayList<>();

        recipeDAO.findAll().forEach(allRecipe::add);
        return allRecipe;
    }
    public Page<Recipe> findAllByPage(Pageable pageable) {
        return recipeDAO.findAll(pageable);
    }
}
