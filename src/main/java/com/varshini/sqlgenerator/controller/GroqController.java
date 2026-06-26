package com.varshini.sqlgenerator.controller;

import com.varshini.sqlgenerator.service.GroqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groq")
public class GroqController {

    @Autowired
    private GroqService groqService;

    @GetMapping("/test")
    public String test() {
        return "Groq Working";
    }

    @PostMapping("/generate")
    public String generate(@RequestBody String prompt) {
        return groqService.generateSql(prompt);
    }
}