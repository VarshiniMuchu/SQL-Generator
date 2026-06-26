package com.varshini.sqlgenerator.dto;

public class QueryResponse {

    private String sql;

    public QueryResponse(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}