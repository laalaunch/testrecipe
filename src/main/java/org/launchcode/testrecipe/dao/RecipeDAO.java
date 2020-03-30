package org.launchcode.testrecipe.dao;

import org.launchcode.testrecipe.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RecipeDAO extends CrudRepository<Recipe, Integer>, PagingAndSortingRepository<Recipe, Integer> {
    Page<Recipe> findAll(Pageable pageable);
}