package com.varshini.sqlgenerator.controller;

import com.varshini.sqlgenerator.dto.QueryRequest;
import com.varshini.sqlgenerator.dto.QueryResponse;
import com.varshini.sqlgenerator.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.varshini.sqlgenerator.service.HistoryService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private QueryService queryService;
    @Autowired
    private HistoryService historyService;

    @PostMapping("/generate")
    public QueryResponse generate(
            HttpServletRequest servletRequest,
            @RequestBody QueryRequest request) {

        String sql =
                queryService.generateSql(
                        request.getPrompt());

        String email =
                (String) servletRequest
                        .getAttribute("email");

        historyService.saveHistory(
                email,
                request.getPrompt(),
                sql);


        return new QueryResponse(sql);
    }
}