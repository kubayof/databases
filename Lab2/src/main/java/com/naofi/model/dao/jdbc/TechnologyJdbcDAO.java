package com.naofi.model.dao.jdbc;

import com.naofi.model.dao.AbstractDAO;
import com.naofi.model.dao.interfaces.TechnologyDAO;
import com.naofi.model.entity.Technology;
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
        return template.queryForObject("select * from technologies where id = :id",
                new MapSqlParameterSource().addValue("id", id),
                new BeanPropertyRowMapper<>(Technology.class));
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
        return template.query("select * from technoloies where id in" +
                        "(select technology_id from programmers_technologies where programmer_id = :programmer_id)",
                new MapSqlParameterSource().addValue("programmer_id", programmerId),
                new BeanPropertyRowMapper<>(Technology.class));
    }

    @Override
    public List<Technology> getByProjectId(int projectId) {
        return template.query("select * from technologies where id in" +
                        "(select * from projects_technologies where project_id = :project_id)",
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
}
