package com.srivatsa.projects.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeProperties {
    private String prepTime;
    private String cookTime;
    private String totalTime;
    private String yields;
}
