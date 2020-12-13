package com.srivatsa.projects.service;

import com.srivatsa.projects.entity.RecipeType;
import com.srivatsa.projects.exception.RecipeTypeNotFound;
import com.srivatsa.projects.util.RecipeTypeCreateWrapper;
import com.srivatsa.projects.util.RecipeTypeUpdateWrapper;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RecipeTypeService {
    RecipeType addRecipeType(RecipeTypeCreateWrapper wrapper);
    List<RecipeType> getRecipeTypes();
    RecipeType  editRecipeType(RecipeTypeUpdateWrapper wrapper) throws RecipeTypeNotFound;
    void deleteRecipeType(String id);
}
