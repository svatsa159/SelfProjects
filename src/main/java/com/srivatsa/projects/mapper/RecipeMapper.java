package com.srivatsa.projects.mapper;

import com.srivatsa.projects.entity.Recipe;
import com.srivatsa.projects.entity.RecipeType;
import com.srivatsa.projects.util.RecipeCreateWrapper;
import com.srivatsa.projects.util.RecipeUpdateWrapper;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper {
    public Recipe RecipeCreateWrapperToRecipe(RecipeCreateWrapper wrapper, RecipeType recipeType){
        Recipe recipe = new Recipe();
        recipe.setDirections(wrapper.getDirections());
        recipe.setIngredients(wrapper.getIngredients());
        recipe.setProperties(wrapper.getProperties());
        recipe.setRecipeType(recipeType);
        recipe.setTitle(wrapper.getTitle());
        return recipe;
    }

    public Recipe RecipeUpdateWrapperToRecipe(RecipeUpdateWrapper wrapper, Recipe recipe, RecipeType recipeType){
        recipe.setDirections(wrapper.getDirections());
        recipe.setIngredients(wrapper.getIngredients());
        recipe.setProperties(wrapper.getProperties());
        recipe.setRecipeType(recipeType);
        recipe.setTitle(wrapper.getTitle());
        return recipe;
    }

}
