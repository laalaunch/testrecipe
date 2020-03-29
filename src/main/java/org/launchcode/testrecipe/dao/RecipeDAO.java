package org.launchcode.testrecipe.dao;

import org.launchcode.testrecipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeDAO extends JpaRepository<Recipe, Integer> {

    List<Recipe> findAll();

}
