package com.srivatsa.projects;

import com.srivatsa.projects.entity.RecipeType;
import com.srivatsa.projects.repository.RecipeTypeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ProjectsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectsApplication.class, args);
    }

}
