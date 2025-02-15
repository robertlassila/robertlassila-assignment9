package com.coderscampus.assignment9.service;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.repository.RecipeRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipes() {
        return recipeRepository.getAllRecipes();
    }

    public List<Recipe> getGlutenFreeRecipes() {
        return getRecipes().stream()
                .filter(recipe -> recipe.getGlutenFree())
                .collect(Collectors.toList());
    }

    public List<Recipe> getVeganRecipes() {
        return getRecipes().stream()
                .filter(recipe -> recipe.getVegan())
                .collect(Collectors.toList());
    }
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return getRecipes().stream()
                .filter(recipe -> recipe.getVegan())
                .filter(recipe -> recipe.getGlutenFree())
                .collect(Collectors.toList());
    }

    public List<Recipe> getVegetarianRecipes() {
        return getRecipes().stream()
                .filter(recipe -> recipe.getVegetarian())
                .collect(Collectors.toList());
    }

    }


