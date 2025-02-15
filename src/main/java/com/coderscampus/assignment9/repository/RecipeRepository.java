package com.coderscampus.assignment9.repository;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.FileService;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {
    private List<Recipe> recipes = new ArrayList<>();
    private final String filename = "recipes.txt";
    private final FileService fileService;


    public RecipeRepository(FileService fileService) {
        this.fileService = fileService;
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }


    @PostConstruct
    private void readRecipes() {
        List<CSVRecord> records = fileService.readFile(filename);
        for (CSVRecord record : records) {
                Recipe recipe = new Recipe(
                        Integer.parseInt(record.get("Cooking Minutes")),
                        Boolean.parseBoolean(record.get("Dairy Free")),
                        Boolean.parseBoolean(record.get("Gluten Free")),
                        record.get("Instructions"),
                        Double.parseDouble(record.get("Preparation Minutes")),
                        Double.parseDouble(record.get("Price Per Serving")),
                        Integer.parseInt(record.get("Ready In Minutes")),
                        Integer.parseInt(record.get("Servings")),
                        Double.parseDouble(record.get("Spoonacular Score")),
                        record.get("Title"),
                        Boolean.parseBoolean(record.get("Vegan")),
                        Boolean.parseBoolean(record.get("Vegetarian"))
                );
                recipes.add(recipe);
            }
        }
    }

