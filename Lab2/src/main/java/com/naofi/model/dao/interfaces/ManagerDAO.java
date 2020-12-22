package com.naofi.model.dao.interfaces;

import com.naofi.model.dao.DAO;
import com.naofi.model.entity.Manager;

import java.util.List;

/**
 * Extends DAO with methods specific to 'managers' table
 */
public interface ManagerDAO extends DAO {
    @Override
    Manager getById(int id);
    List<Manager> getByFirstName(String firstName);
    List<Manager> getByLastName(String lastName);
    Manager getByProjectId(int projectId);
    Manager getByProgrammerId(int programmerId);

    int save(Manager manager);
    int update(Manager manager);
}
