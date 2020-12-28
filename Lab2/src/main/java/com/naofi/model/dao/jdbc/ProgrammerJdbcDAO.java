package com.naofi.model.dao.jdbc;

import com.naofi.model.dao.AbstractDAO;
import com.naofi.model.dao.interfaces.ProgrammerDAO;
import com.naofi.model.entity.Programmer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Stream;

public class ProgrammerJdbcDAO extends AbstractDAO implements ProgrammerDAO {
    public ProgrammerJdbcDAO(DataSource ds) {
        super(ds);
    }

    @Override
    public int save(Programmer programmer) {
        return template.update("INSERT INTO programmers (first_name, last_name, manager)" +
                        "VALUES (:first_name, :last_name, :manager)",
                new MapSqlParameterSource()
                        .addValue("first_name", programmer.getFirstName())
                        .addValue("last_name", programmer.getLastName())
                        .addValue("manager", programmer.getManagerId()));
    }

    @Override
    public Programmer getById(int id) {
        try {
            return template.queryForObject("select * from programmers where id = :id",
                    new MapSqlParameterSource().addValue("id", id),
                    new BeanPropertyRowMapper<>(Programmer.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(int id) {
        return template.update("delete from programmers where id = :id",
                new MapSqlParameterSource().addValue("id", id));
    }

    @Override
    public List<Programmer> getByFirstName(String firstName) {
        return template.query("select * from programmers where first_name like :first_name",
                new MapSqlParameterSource().addValue("first_name", firstName),
                new BeanPropertyRowMapper<>(Programmer.class));
    }

    @Override
    public List<Programmer> getByLastName(String lastName) {
        return template.query("select * from programmers where last_name like :last_name",
                new MapSqlParameterSource().addValue("last_name", lastName),
                new BeanPropertyRowMapper<>(Programmer.class));
    }

    @Override
    public List<Programmer> getByManagerId(int managerId) {
        return template.query("select * from programmers where manager = :manager_id",
                new MapSqlParameterSource().addValue("manager_id", managerId),
                new BeanPropertyRowMapper<>(Programmer.class));
    }

    @Override
    public List<Programmer> getByTechnologyId(int technologyId) {
        return template.query("select * from programmers where id in " +
                        "(select programmer_id from programmers_technologies where technology_id = :technology_id)",
                new MapSqlParameterSource().addValue("technology_id", technologyId),
                new BeanPropertyRowMapper<>(Programmer.class));
    }

    @Override
    public int update(Programmer programmer) {
        return template.update("update programmers set first_name = :first_name, last_name = :last_name," +
                        "manager = :manager_id where id = :programmer_id",
                new MapSqlParameterSource()
                        .addValue("programmer_id", programmer.getId())
                        .addValue("first_name", programmer.getFirstName())
                        .addValue("last_name", programmer.getLastName())
                        .addValue("manager_id", programmer.getManagerId()));
    }

    @Override
    public void populate(int count) {
        SqlParameterSource[] sources = Stream.generate(MapSqlParameterSource::new)
                .limit(count).toArray(SqlParameterSource[]::new);

        template.batchUpdate("insert into programmers (first_name, last_name, manager) " +
                        "select substring(md5(random()::text) from 1 for (random() * 5 + 5)::int), " +
                        "substring(md5(random()::text) from 1 for (random() * 5 + 5)::int), " +
                        "(select id from managers order by random() limit 1)",
                sources);
    }
}
