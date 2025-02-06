package com.coderscampus.assignment9.service;

import com.coderscampus.assignment9.domain.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private List<Recipe> recipes;

    public RecipeService() throws IOException {
        this(null);
    }

    public RecipeService(String filename) throws IOException {
        try {
            this.recipes = loadRecipesFromFile("recipes.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
    private List<Recipe> loadRecipesFromFile(String filename) throws IOException {
        List<Recipe> recipes = new ArrayList<>();

        try (Reader in = new FileReader(filename)) {
            Iterable<CSVRecord> records = null;
            try {
                records = CSVFormat.DEFAULT
                        .withIgnoreSurroundingSpaces()
                        .withHeader()
                        .withSkipHeaderRecord()
                        .withTrim()
                        .withEscape('\\')
                        .withQuote('"')
                        .parse(in);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            for (CSVRecord record : records) {
                try {
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
                } catch (NumberFormatException | NullPointerException e) {
                    System.err.println("Skipping a record due to invalid data: " + e.getMessage());
                }
            }
        }
        return recipes;
    }


}
