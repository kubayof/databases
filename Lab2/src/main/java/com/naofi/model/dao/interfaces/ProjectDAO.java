package com.naofi.model.dao.interfaces;

import com.naofi.model.dao.DAO;
import com.naofi.model.entity.Project;

import java.util.List;

/**
 * Extends DAO with methods specific to 'projects' table
 */
public interface ProjectDAO extends DAO {
    @Override
    Project getById(int id);
    List<Project> getByName(String name);
    Project getByManagerId(int managerId);
    List<Project> getByTechnologyId(int technologyId);

    int save(Project project);
    int update(Project project);
}
