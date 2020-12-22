package com.naofi.model.dao.jdbc;

import com.naofi.model.dao.AbstractDAO;
import com.naofi.model.dao.interfaces.ManagerDAO;
import com.naofi.model.entity.Manager;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import javax.sql.DataSource;
import java.util.List;

public class ManagerJdbcDAO extends AbstractDAO implements ManagerDAO {
    public ManagerJdbcDAO(DataSource ds) {
        super(ds);
    }

    @Override
    public int save(Manager manager) {
        return template.update("INSERT INTO managers (first_name, last_name) VALUES (:first_name, :last_name)",
                new MapSqlParameterSource()
                        .addValue("first_name", manager.getFirstName())
                        .addValue("last_name", manager.getLastName()));
    }

    @Override
    public int deleteById(int id) {
        return template.update("delete from managers where id = :id",
                new MapSqlParameterSource().addValue("id", id));
    }

    @Override
    public Manager getById(int id) {
        return template.queryForObject("select * from managers where id = :id",
                new MapSqlParameterSource().addValue("id", id),
                new BeanPropertyRowMapper<>(Manager.class));
    }

    @Override
    public List<Manager> getByFirstName(String firstName) {
        return template.query("select * from managers where first_name like :first_name",
                new MapSqlParameterSource().addValue("first_name", firstName),
                new BeanPropertyRowMapper<>(Manager.class));
    }

    @Override
    public List<Manager> getByLastName(String lastName) {
        return template.query("select * from managers where last_name like :last_name",
                new MapSqlParameterSource().addValue("last_name", lastName),
                new BeanPropertyRowMapper<>(Manager.class));
    }

    @Override
    public Manager getByProjectId(int projectId) {
        return template.queryForObject("select * from managers where id = " +
                        "(select manager from projects where id = :project_id)",
                new MapSqlParameterSource().addValue("project_id", projectId),
                new BeanPropertyRowMapper<>(Manager.class));
    }

    @Override
    public Manager getByProgrammerId(int programmerId) {
        return template.queryForObject("select * from managers where id = " +
                        "(select manager from programmers where id = :programmer_id)",
                new MapSqlParameterSource().addValue("programmer_id", programmerId),
                new BeanPropertyRowMapper<>(Manager.class));
    }

    @Override
    public int update(Manager manager) {
        return template.update("update managers set first_name = :first_name, " +
                        "last_name = :last_name where id = :manager_id",
                new MapSqlParameterSource()
                        .addValue("first_name", manager.getFirstName())
                        .addValue("last_name", manager.getLastName())
                        .addValue("manager_id", manager.getId()));
    }
}
