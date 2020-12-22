package com.naofi.model.dao.interfaces;

import com.naofi.model.dao.DAO;
import com.naofi.model.entity.Technology;

import java.util.List;

/**
 * Extends DAO with methods specific to 'technologies' table
 */
public interface TechnologyDAO extends DAO {
    @Override
    Technology getById(int id);
    List<Technology> getByName(String name);
    List<Technology> getByProgrammerId(int programmerId);
    List<Technology> getByProjectId(int projectId);

    int save(Technology technology);
    int update(Technology technology);
}
