package com.srivatsa.projects.util;

import com.srivatsa.projects.entity.RecipeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeUpdateWrapper {
    String id;
    private String title;
    private RecipeProperties properties;
    private List<String> ingredients;
    private List<String> directions;
    private String recipeType;
}
