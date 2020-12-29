package com.naofi.model.dao.jdbc;

import com.naofi.model.dao.AbstractDAO;
import com.naofi.model.dao.interfaces.ManagerDAO;
import com.naofi.model.entity.Manager;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        try {
            return template.queryForObject("select * from managers where id = :id",
                    new MapSqlParameterSource().addValue("id", id),
                    new BeanPropertyRowMapper<>(Manager.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
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
        try {
            return template.queryForObject("select * from managers where id = " +
                            "(select manager from projects where id = :project_id)",
                    new MapSqlParameterSource().addValue("project_id", projectId),
                    new BeanPropertyRowMapper<>(Manager.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Manager getByProgrammerId(int programmerId) {
        try {
            return template.queryForObject("select * from managers where id = " +
                            "(select manager from programmers where id = :programmer_id)",
                    new MapSqlParameterSource().addValue("programmer_id", programmerId),
                    new BeanPropertyRowMapper<>(Manager.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
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

    @Override
    public void populate(int count) {
        template.update("insert into managers (first_name, last_name) " +
                        "(select substring(md5(random()::text) from 1 for (random() * 5 + 5)::int), " +
                        "substring(md5(random()::text) from 1 for (random() * 5 + 5)::int) from generate_series(1, :count) g)",
                new MapSqlParameterSource().addValue("count", count));
    }

    @Override
    public List<Manager> getBy(Manager manager) {
        List<String> conds = new ArrayList<>();
        MapSqlParameterSource params = new MapSqlParameterSource();

        if (manager.getId() != null) {
            conds.add("id = :id");
            params.addValue("id", manager.getId());
        }

        if ((manager.getFirstName() != null) && !(manager.getFirstName().isEmpty())) {
            conds.add("first_name like :first_name");
            params.addValue("first_name", manager.getFirstName());
        }

        if ((manager.getFirstName() != null) && !(manager.getFirstName().isEmpty())) {
            conds.add("last_name like :last_name");
            params.addValue("last_name", manager.getLastName());
        }

        String cond = String.join(" and ", conds);

        String query = "select * from managers";
        if (!cond.isEmpty()) {
            query += " where " + cond;
        }

        return template.query(query, params, new BeanPropertyRowMapper<>(Manager.class));
    }
}
