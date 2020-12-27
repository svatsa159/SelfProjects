package com.srivatsa.projects.controller;


import com.srivatsa.projects.entity.Recipe;
import com.srivatsa.projects.entity.RecipeType;
import com.srivatsa.projects.exception.RecipeNotFound;
import com.srivatsa.projects.exception.RecipeTypeNotFound;
import com.srivatsa.projects.service.RecipeService;
import com.srivatsa.projects.service.RecipeTypeService;
import com.srivatsa.projects.util.RecipeCreateWrapper;
import com.srivatsa.projects.util.RecipeTypeCreateWrapper;
import com.srivatsa.projects.util.RecipeTypeUpdateWrapper;
import com.srivatsa.projects.util.RecipeUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity(recipeService.getAllRecipes(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable String id) throws RecipeNotFound {
        return new ResponseEntity(recipeService.getRecipeById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/type/{id}")
    public ResponseEntity<List<Recipe>> getAllRecipesByRecipeType(@PathVariable String id) {
        return new ResponseEntity(recipeService.getRecipesByRecipeType(id), HttpStatus.OK);
    }

    @PostMapping(value="/")
    public ResponseEntity<Recipe> saveRecipe(@RequestBody RecipeCreateWrapper wrapper) throws RecipeTypeNotFound {
        return new ResponseEntity(recipeService.saveRecipe(wrapper), HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<RecipeType> editRecipe(@RequestBody RecipeUpdateWrapper wrapper) throws RecipeNotFound, RecipeTypeNotFound {
        System.out.println(wrapper);
        return new ResponseEntity(recipeService.updateRecipe(wrapper), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRecipe(@PathVariable String id) throws RecipeNotFound {
        recipeService.deleteRecipe(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
