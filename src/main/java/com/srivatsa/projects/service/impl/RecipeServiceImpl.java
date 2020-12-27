package com.srivatsa.projects.service.impl;

import com.srivatsa.projects.entity.Recipe;
import com.srivatsa.projects.entity.RecipeType;
import com.srivatsa.projects.exception.RecipeNotFound;
import com.srivatsa.projects.exception.RecipeTypeNotFound;
import com.srivatsa.projects.mapper.RecipeMapper;
import com.srivatsa.projects.repository.RecipeRepository;
import com.srivatsa.projects.repository.RecipeTypeRepository;
import com.srivatsa.projects.service.RecipeService;
import com.srivatsa.projects.util.RecipeCreateWrapper;
import com.srivatsa.projects.util.RecipeUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeTypeRepository recipeTypeRepository;

    @Autowired
    RecipeMapper mapper;

    @Override
    public List<Recipe> getRecipesByRecipeType(String recipeTypeId) {
        return recipeRepository.getRecipesByRecipeType_Id(recipeTypeId);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(String id) throws RecipeNotFound{
        Recipe recipe = recipeRepository.findById(id).orElse(null);
        if(recipe==null) {
            throw new RecipeNotFound(id);
        }
        return recipe;
    }

    @Override
    public Recipe saveRecipe(RecipeCreateWrapper wrapper) throws RecipeTypeNotFound {
        RecipeType rt = recipeTypeRepository.findById(wrapper.getRecipeType()).orElse(null);
        if(rt==null){
            throw new RecipeTypeNotFound(wrapper.getRecipeType());
        }
        return recipeRepository.save(mapper.RecipeCreateWrapperToRecipe(wrapper, rt));
    }

    @Override
    public Recipe updateRecipe(RecipeUpdateWrapper wrapper) throws RecipeNotFound, RecipeTypeNotFound {
        Recipe recipe = recipeRepository.findById(wrapper.getId()).orElse(null);
        if(recipe==null) {
            throw new RecipeNotFound(wrapper.getId());
        }
        RecipeType rt = recipeTypeRepository.findById(wrapper.getRecipeType()).orElse(null);
        if(rt==null){
            throw new RecipeTypeNotFound(wrapper.getRecipeType());
        }
        return recipeRepository.save(mapper.RecipeUpdateWrapperToRecipe(wrapper,recipe, rt));
    }

    @Override
    public void deleteRecipe(String recipeId) throws RecipeNotFound {
        Recipe recipe = recipeRepository.findById(recipeId).orElse(null);
        if(recipe==null) {
            throw new RecipeNotFound(recipeId);
        }
        recipeRepository.delete(recipe);
    }
}
