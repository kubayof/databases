package com.naofi.model.dao.jdbc;

import com.naofi.model.dao.AbstractDAO;
import com.naofi.model.dao.interfaces.TechnologyDAO;
import com.naofi.model.entity.Technology;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class TechnologyJdbcDAO extends AbstractDAO implements TechnologyDAO {
    public TechnologyJdbcDAO(DataSource ds) {
        super(ds);
    }

    @Override
    public Technology getById(int id) {
        try {
            return template.queryForObject("select * from technologies where id = :id",
                    new MapSqlParameterSource().addValue("id", id),
                    new BeanPropertyRowMapper<>(Technology.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(int id) {
        return template.update("delete from technologies where id = :id",
                new MapSqlParameterSource().addValue("id", id));
    }

    @Override
    public List<Technology> getByName(String name) {
        return template.query("select * from technologies where name like :name",
                new MapSqlParameterSource().addValue("name", name),
                new BeanPropertyRowMapper<>(Technology.class));
    }

    @Override
    public List<Technology> getByProgrammerId(int programmerId) {
        return template.query("select * from technologies where id in " +
                        "(select technology_id from programmers_technologies where programmer_id = :programmer_id)",
                new MapSqlParameterSource().addValue("programmer_id", programmerId),
                new BeanPropertyRowMapper<>(Technology.class));
    }

    @Override
    public List<Technology> getByProjectId(int projectId) {
        return template.query("select * from technologies where id in " +
                        "(select technology_id from projects_technologies where project_id = :project_id)",
                new MapSqlParameterSource().addValue("project_id", projectId),
                new BeanPropertyRowMapper<>(Technology.class));
    }

    @Override
    public int save(Technology technology) {
        return template.update("insert into technologies (name) values (:name)",
                new MapSqlParameterSource()
                        .addValue("name", technology.getName()));
    }

    @Override
    public int update(Technology technology) {
        return template.update("update technologies set name = :name where id = :id",
                new MapSqlParameterSource()
                        .addValue("name", technology.getName())
                        .addValue("id", technology.getId()));
    }

    @Override
    public void populate(int count) {
        template.update("insert into technologies (name) " +
                        "(select substring(md5(random()::text) from 1 for (random() * 5 + 5)::int) " +
                        "from generate_series(1, :count) g)",
                new MapSqlParameterSource().addValue("count", count));
    }
}
