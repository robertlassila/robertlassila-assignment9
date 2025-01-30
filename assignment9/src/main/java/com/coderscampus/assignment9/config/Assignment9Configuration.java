package com.coderscampus.assignment9.config;

import com.coderscampus.assignment9.service.FileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Assignment9Configuration {

    @Bean
    public FileService fileService () {
        return new FileService("test.txt");
    }
    
}
