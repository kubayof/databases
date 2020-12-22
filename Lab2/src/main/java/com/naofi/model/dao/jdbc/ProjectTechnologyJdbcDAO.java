package com.naofi.model.dao.jdbc;

import com.naofi.model.dao.AbstractDAO;
import com.naofi.model.dao.interfaces.ProjectTechnologyDAO;
import com.naofi.model.entity.ProjectTechnology;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import javax.sql.DataSource;
import java.util.List;

public class ProjectTechnologyJdbcDAO extends AbstractDAO implements ProjectTechnologyDAO {
    public ProjectTechnologyJdbcDAO(DataSource ds) {
        super(ds);
    }

    @Override
    public List<ProjectTechnology> getByProjectId(int projectId) {
        return template.query("select * from projects_technologies where project_id = :project_id",
                new MapSqlParameterSource().addValue("project_id", projectId),
                new BeanPropertyRowMapper<>(ProjectTechnology.class));
    }

    @Override
    public List<ProjectTechnology> getByTechnologyId(int technologyId) {
        return template.query("select * from projects_technologies where technology_id = :technology_id",
                new MapSqlParameterSource().addValue("technology_id", technologyId),
                new BeanPropertyRowMapper<>(ProjectTechnology.class));
    }

    @Override
    public ProjectTechnology getById(int projectId, int technologyId) {
        return template.queryForObject("select * from projects_technologies where " +
                        "project_id = :project_id and technology_id = :technology_id",
                new MapSqlParameterSource()
                        .addValue("project_id", projectId)
                        .addValue("technology_id", technologyId),
                new BeanPropertyRowMapper<>(ProjectTechnology.class));
    }

    @Override
    public int save(ProjectTechnology entity) {
        return template.update("insert into projects_technologies (project_id, technology_id) " +
                        "values (:project_id, :technology_id)",
                new MapSqlParameterSource()
                        .addValue("project_id", entity.getProjectId())
                        .addValue("technology_id", entity.getTechnologyId()));
    }

    @Override
    public int delete(ProjectTechnology entity) {
        return template.update("delete from projects_technologies where " +
                        "project_id = :project_id and technology_id = :technology_id",
                new MapSqlParameterSource()
                        .addValue("project_id", entity.getProjectId())
                        .addValue("technology_id", entity.getTechnologyId()));
    }
}
