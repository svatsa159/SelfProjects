package com.srivatsa.projects.service;

import com.srivatsa.projects.entity.Recipe;
import com.srivatsa.projects.exception.RecipeNotFound;
import com.srivatsa.projects.exception.RecipeTypeNotFound;
import com.srivatsa.projects.util.RecipeCreateWrapper;
import com.srivatsa.projects.util.RecipeUpdateWrapper;

import java.util.List;

public interface RecipeService {
    List<Recipe> getRecipesByRecipeType(String recipeTypeId);
    List<Recipe> getAllRecipes();
    Recipe saveRecipe(RecipeCreateWrapper wrapper) throws RecipeTypeNotFound;
    Recipe updateRecipe(RecipeUpdateWrapper wrapper) throws RecipeNotFound, RecipeTypeNotFound;
    void deleteRecipe(String recipeId) throws RecipeNotFound;
}
