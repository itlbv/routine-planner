package com.itlbv.routineplanner.repository;

import com.itlbv.routineplanner.model.Routine;

import java.util.List;

public interface RoutineRepository {
    Routine save(Routine routine);

    boolean delete(int id);

    Routine get(int id);

    List<Routine> getAll();
}
