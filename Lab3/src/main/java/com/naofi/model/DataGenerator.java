package com.naofi.model;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;
import java.util.stream.Stream;

@Component("generator")
@RequestScope
public class DataGenerator {
    private final NamedParameterJdbcTemplate template;

    public DataGenerator(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }

    public void populate(int managersCount,
                         int technologiesCount,
                         int projectsCount,
                         int programmersCount,
                         int projectsTechnologiesCount,
                         int programmersTechnologiesCount) {
        populateManagers(managersCount);
        populateTechnologies(technologiesCount);
        populateProjects(projectsCount);
        populateProgrammers(programmersCount);
        populateProjectsTechnologies(projectsTechnologiesCount);
        populateProgrammersTechnologies(programmersTechnologiesCount);
    }

    private void populateManagers(int count) {
        template.update("insert into managers (first_name, last_name) " +
                        "(select substring(md5(random()::text) from 1 for (random() * 5 + 5)::int), " +
                        "substring(md5(random()::text) from 1 for (random() * 5 + 5)::int) from generate_series(1, :count) g)",
                new MapSqlParameterSource().addValue("count", count));
    }

    private void populateProgrammers(int count) {
        SqlParameterSource[] sources = Stream.generate(MapSqlParameterSource::new)
                .limit(count).toArray(SqlParameterSource[]::new);

        template.batchUpdate("insert into programmers (first_name, last_name, manager) " +
                        "select substring(md5(random()::text) from 1 for (random() * 5 + 5)::int), " +
                        "substring(md5(random()::text) from 1 for (random() * 5 + 5)::int), " +
                        "(select id from managers order by random() limit 1)",
                sources);
    }

    private void populateProgrammersTechnologies(int count) {
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

    private void populateProjects(int count) {
        SqlParameterSource[] sources = Stream.generate(MapSqlParameterSource::new)
                .limit(count).toArray(SqlParameterSource[]::new);

        template.batchUpdate("insert into projects (name, manager) " +
                        "select substring(md5(random()::text) from 1 for (random() * 5 + 5)::int), " +
                        "(select id from managers where id not in (select manager from projects) order by random() limit 1)",
                sources);
    }

    private void populateProjectsTechnologies(int count) {
        SqlParameterSource[] sources = Stream.generate(MapSqlParameterSource::new)
                .limit(count).toArray(SqlParameterSource[]::new);

        template.batchUpdate("with random_project_id as (select id from projects order by random() limit 1) " +
                        "insert into projects_technologies (project_id, technology_id) " +
                        "select (select id from random_project_id) as pid, " +
                        "       (select id from technologies " +
                        "       where id not in (select technology_id from projects_technologies " +
                        "       where project_id in (select id from random_project_id)) " +
                        "           order by random() limit 1)",
                sources);
    }

    private void populateTechnologies(int count) {
        template.update("insert into technologies (name) " +
                        "(select substring(md5(random()::text) from 1 for (random() * 5 + 5)::int) " +
                        "from generate_series(1, :count) g)",
                new MapSqlParameterSource().addValue("count", count));
    }
}
