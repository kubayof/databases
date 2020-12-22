package com.naofi.model.dao.jdbc;

import com.naofi.model.dao.AbstractDAO;
import com.naofi.model.dao.interfaces.ProjectDAO;
import com.naofi.model.entity.Project;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ProjectJdbcDAO extends AbstractDAO implements ProjectDAO {
    public ProjectJdbcDAO(DataSource ds) {
        super(ds);
    }


    @Override
    public Project getById(int id) {
        return template.queryForObject("select * from projects where id = :id",
                new MapSqlParameterSource().addValue("id", id),
                new BeanPropertyRowMapper<>(Project.class));
    }

    @Override
    public int deleteById(int id) {
        return template.update("delete from projects where id = :id",
                new MapSqlParameterSource().addValue("id", id));
    }

    @Override
    public List<Project> getByName(String name) {
        return template.query("select * from projects where name = :name",
                new MapSqlParameterSource().addValue("name", name),
                new BeanPropertyRowMapper<>(Project.class));
    }

    @Override
    public Project getByManagerId(int managerId) {
        return template.queryForObject("select * from projects where manager = :manager_id",
                new MapSqlParameterSource().addValue("manager_id", managerId),
                new BeanPropertyRowMapper<>(Project.class));
    }

    @Override
    public List<Project> getByTechnologyId(int technologyId) {
        return template.query("select * from projects where id in" +
                        "(select project_id from projects_technologies where technology_id = :technology_id)",
                new MapSqlParameterSource().addValue("technology_id", technologyId),
                new BeanPropertyRowMapper<>(Project.class));
    }

    @Override
    public int save(Project project) {
        return template.update("insert into projects (name, manager) values (:name, :manager_id)",
                new MapSqlParameterSource()
                        .addValue("name", project.getName())
                        .addValue("manager_id", project.getManagerId()));
    }

    @Override
    public int update(Project project) {
        return template.update("update projects set name = :name, manager = :manager_id where id = :id",
                new MapSqlParameterSource()
                        .addValue("name", project.getName())
                        .addValue("manager_id", project.getManagerId())
                        .addValue("id", project.getId()));
    }
}
