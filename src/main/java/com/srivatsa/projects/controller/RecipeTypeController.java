package com.srivatsa.projects.controller;


import com.srivatsa.projects.entity.RecipeType;
import com.srivatsa.projects.exception.RecipeTypeNotFound;
import com.srivatsa.projects.service.RecipeTypeService;
import com.srivatsa.projects.util.RecipeTypeCreateWrapper;
import com.srivatsa.projects.util.RecipeTypeUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/recipe-type")
public class RecipeTypeController {
    @Autowired
    RecipeTypeService recipeTypeService;

    @GetMapping(value = "/")
    public ResponseEntity<List<RecipeType>> getAllRecipeTypes() {
        return new ResponseEntity(recipeTypeService.getRecipeTypes(), HttpStatus.OK);
    }

    @PostMapping(value="/")
    public ResponseEntity<RecipeType> saveRecipe(@RequestBody RecipeTypeCreateWrapper wrapper){
        System.out.println("POST "+wrapper);
        return new ResponseEntity(recipeTypeService.addRecipeType(wrapper), HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<RecipeType> editRecipe(@RequestBody RecipeTypeUpdateWrapper wrapper) throws RecipeTypeNotFound {
        System.out.println(wrapper);
        return new ResponseEntity(recipeTypeService.editRecipeType(wrapper), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRecipe(@PathVariable String id) throws RecipeTypeNotFound {
        recipeTypeService.deleteRecipeType(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
