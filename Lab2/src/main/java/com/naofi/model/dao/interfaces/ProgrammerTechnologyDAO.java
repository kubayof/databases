package com.naofi.model.dao.interfaces;

import com.naofi.model.entity.ProgrammerTechnology;

import java.util.List;

public interface ProgrammerTechnologyDAO {
    List<ProgrammerTechnology> getByProgrammerId(int programmerId);
    List<ProgrammerTechnology> getByTechnologyId(int technologyId);
    ProgrammerTechnology getById(int programmerId, int technologyId);

    int save(ProgrammerTechnology entity);
    int delete(ProgrammerTechnology entity);
}
