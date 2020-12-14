package com.srivatsa.projects.repository;

import com.srivatsa.projects.entity.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String>{
    List<Recipe> getRecipesByRecipeType_Id(String id);
}
