package com.srivatsa.projects.entity;

import com.srivatsa.projects.util.RecipeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    private String id;
    private String title;
    private RecipeProperties properties;
    private List<String> ingredients;
    private List<String> directions;
    private RecipeType recipeType;
}
