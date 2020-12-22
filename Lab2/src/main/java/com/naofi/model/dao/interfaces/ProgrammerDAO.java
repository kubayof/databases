package com.naofi.model.dao.interfaces;

import com.naofi.model.dao.DAO;
import com.naofi.model.entity.Programmer;

import java.util.List;

/**
 * Extends DAO with methods specific to 'projects' table
 */
public interface ProgrammerDAO extends DAO {
    @Override
    Programmer getById(int id);
    List<Programmer> getByFirstName(String firstName);
    List<Programmer> getByLastName(String lastName);
    List<Programmer> getByManagerId(int managerId);
    List<Programmer> getByTechnologyId(int technologyId);

    int save(Programmer manager);
    int update(Programmer programmer);
}
