package com.srivatsa.projects.service.impl;

import com.srivatsa.projects.entity.RecipeType;
import com.srivatsa.projects.exception.RecipeTypeNotFound;
import com.srivatsa.projects.repository.RecipeTypeRepository;
import com.srivatsa.projects.service.RecipeTypeService;
import com.srivatsa.projects.util.RecipeTypeCreateWrapper;
import com.srivatsa.projects.util.RecipeTypeUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeTypeServiceImpl implements RecipeTypeService {

    @Autowired
    RecipeTypeRepository recipeTypeRepository;

    @Override
    public RecipeType addRecipeType(RecipeTypeCreateWrapper wrapper) {
        RecipeType rt = new RecipeType();
        rt.setName(wrapper.getName());
        return recipeTypeRepository.insert(rt);
    }

    @Override
    public List<RecipeType> getRecipeTypes() {
        return recipeTypeRepository.findAll();
    }

    @Override
    public RecipeType editRecipeType(RecipeTypeUpdateWrapper wrapper) throws RecipeTypeNotFound {
        RecipeType rt = recipeTypeRepository.findById(wrapper.getId()).orElse(null);
        if(rt==null){
            throw new RecipeTypeNotFound(wrapper.getId());
        }
        rt.setName(wrapper.getName());
        return recipeTypeRepository.save(rt);
    }

    @Override
    public void deleteRecipeType(String id) throws RecipeTypeNotFound {
        RecipeType rt = recipeTypeRepository.findById(id).orElse(null);
        if(rt==null){
            throw new RecipeTypeNotFound(id);
        }
        recipeTypeRepository.delete(rt);
    }
}
