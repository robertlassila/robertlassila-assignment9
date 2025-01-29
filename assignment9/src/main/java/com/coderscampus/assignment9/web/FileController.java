package com.coderscampus.assignment9.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    @GetMapping("/hello-world")
    public String helloWorld (){
        return "Hello world!";
    }

//    @PostMapping("/hello-world")
//    public String helloWorldPost (){
//        return "Ok cool, you just posted some data";
//    }

}
