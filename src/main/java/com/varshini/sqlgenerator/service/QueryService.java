package com.varshini.sqlgenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

    @Autowired
    private GroqService groqService;

    public String generateSql(String prompt) {
        return groqService.generateSql(prompt);
    }
}