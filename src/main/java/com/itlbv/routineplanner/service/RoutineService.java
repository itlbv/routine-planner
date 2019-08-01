package com.itlbv.routineplanner.service;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.util.NotFoundException;

import java.util.List;

public interface RoutineService {

    Routine create(Routine routine, int userId);

    void update(Routine routine, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    Routine get(int id, int userId) throws NotFoundException;

    List<Routine> getAll(int userId);
}
