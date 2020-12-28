package com.naofi.model.dao.jdbc;

import com.naofi.model.dao.AbstractDAO;
import com.naofi.model.dao.interfaces.ProgrammerTechnologyDAO;
import com.naofi.model.entity.ProgrammerTechnology;
import com.naofi.model.entity.ProjectTechnology;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Stream;

public class ProgrammerTechnologyJdbcDAO extends AbstractDAO implements ProgrammerTechnologyDAO {
    public ProgrammerTechnologyJdbcDAO(DataSource ds) {
        super(ds);
    }

    @Override
    public List<ProgrammerTechnology> getByProgrammerId(int programmerId) {
        return template.query("select * from programmers_technologies where programmer_id = :programmer_id",
                new MapSqlParameterSource().addValue("programmer_id", programmerId),
                new BeanPropertyRowMapper<>(ProgrammerTechnology.class));
    }

    @Override
    public List<ProgrammerTechnology> getByTechnologyId(int technologyId) {
        return template.query("select * from programmers_technologies where technology_id = :technology_id",
                new MapSqlParameterSource().addValue("technology_id", technologyId),
                new BeanPropertyRowMapper<>(ProgrammerTechnology.class));
    }

    @Override
    public ProgrammerTechnology getById(int programmerId, int technologyId) {
        try {
            return template.queryForObject("select * from programmers_technologies where " +
                            "programmer_id = :programmer_id and technology_id = :technology_id",
                    new MapSqlParameterSource()
                            .addValue("programmer_id", programmerId)
                            .addValue("technology_id", technologyId),
                    new BeanPropertyRowMapper<>(ProgrammerTechnology.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int save(ProgrammerTechnology entity) {
        return template.update("insert into programmers_technologies (programmer_id, technology_id) " +
                        "values (:programmer_id, :technology_id)",
                new MapSqlParameterSource()
                        .addValue("programmer_id", entity.getProgrammerId())
                        .addValue("technology_id", entity.getTechnologyId()));
    }

    @Override
    public int delete(ProgrammerTechnology entity) {
        return template.update("delete from programmers_technologies where " +
                        "programmer_id = :programmer_id and technology_id = :technology_id",
                new MapSqlParameterSource()
                        .addValue("programmer_id", entity.getProgrammerId())
                        .addValue("technology_id", entity.getTechnologyId()));
    }

    @Override
    public void populate(int count) {
        SqlParameterSource[] sources = Stream.generate(MapSqlParameterSource::new)
                .limit(count).toArray(SqlParameterSource[]::new);

        template.batchUpdate("with random_programmer_id as (select id from programmers order by random() limit 1) " +
                        "insert into programmers_technologies (programmer_id, technology_id) " +
                        "select (select id from random_programmer_id) as pid, " +
                        "       (select id from technologies " +
                        "       where id not in (select technology_id from programmers_technologies " +
                        "       where programmer_id in (select id from random_programmer_id)) " +
                        "           order by random() limit 1)",
                sources);
    }
}
