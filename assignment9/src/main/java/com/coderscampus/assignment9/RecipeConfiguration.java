package com.coderscampus.assignment9;

import com.coderscampus.assignment9.service.RecipeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class RecipeConfiguration {
    @Bean
    public RecipeService recipeService() throws IOException {
        return new RecipeService("recipes.txt");
    }
}
