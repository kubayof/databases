package com.naofi.model.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public abstract class AbstractDAO {
    protected final NamedParameterJdbcTemplate template;

    public AbstractDAO(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }
}
