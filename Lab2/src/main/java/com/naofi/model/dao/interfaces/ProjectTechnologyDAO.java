package com.naofi.model.dao.interfaces;

import com.naofi.model.entity.ProjectTechnology;

import java.util.List;

public interface ProjectTechnologyDAO {
    List<ProjectTechnology> getByProjectId(int projectId);
    List<ProjectTechnology> getByTechnologyId(int technologyId);
    ProjectTechnology getById(int projectId, int technologyId);

    int save(ProjectTechnology entity);
    int delete(ProjectTechnology entity);
    void populate(int count);
}
