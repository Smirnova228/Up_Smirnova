package com.example.finalprojectapteka.repository;

import com.example.finalprojectapteka.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
