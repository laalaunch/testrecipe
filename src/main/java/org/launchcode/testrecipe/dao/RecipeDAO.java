package org.launchcode.testrecipe.dao;

import org.launchcode.testrecipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeDAO extends CrudRepository<Recipe, Integer> {
}
