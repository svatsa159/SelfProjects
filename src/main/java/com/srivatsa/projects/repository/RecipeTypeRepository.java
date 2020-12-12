package com.srivatsa.projects.repository;

import com.srivatsa.projects.entity.RecipeType;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RecipeTypeRepository extends MongoRepository<RecipeType, String> {
}
