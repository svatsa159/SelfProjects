package com.srivatsa.projects.exception;

public class RecipeNotFound extends Exception{
    public RecipeNotFound(String id){
        super("Recipe not found with id : " + id);
    }
}
