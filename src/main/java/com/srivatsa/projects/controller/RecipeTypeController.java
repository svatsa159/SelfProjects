package com.srivatsa.projects.controller;


import com.srivatsa.projects.entity.RecipeType;
import com.srivatsa.projects.service.RecipeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe-type")
public class RecipeTypeController {
    @Autowired
    RecipeTypeService recipeTypeService;

    @GetMapping(value = "/")
    public RecipeType getAllUsers() {
        return recipeTypeService.addRecipeType("SS");
    }
}
