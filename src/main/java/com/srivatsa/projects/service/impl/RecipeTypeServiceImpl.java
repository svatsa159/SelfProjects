package com.srivatsa.projects.service.impl;

import com.srivatsa.projects.entity.RecipeType;
import com.srivatsa.projects.repository.RecipeTypeRepository;
import com.srivatsa.projects.service.RecipeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeTypeServiceImpl implements RecipeTypeService {

    @Autowired
    RecipeTypeRepository recipeTypeRepository;

    @Override
    public RecipeType addRecipeType(String name) {
        RecipeType rt = new RecipeType();
        rt.setName(name);
        return recipeTypeRepository.insert(rt);
    }
}
