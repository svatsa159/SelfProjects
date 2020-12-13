package com.srivatsa.projects.exception;

public class RecipeTypeNotFound extends Exception{
    public RecipeTypeNotFound(String id){
        super("Recipe Type not found with id : " + id);
    }
}
