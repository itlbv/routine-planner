package com.itlbv.routineplanner.service;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.util.NotFoundException;

import java.util.List;

public interface RoutineService {

    Routine create(Routine routine);

    void update(Routine routine);

    void delete(int id) throws NotFoundException;

    Routine get(int id) throws NotFoundException;

    List<Routine> getAll();
}
