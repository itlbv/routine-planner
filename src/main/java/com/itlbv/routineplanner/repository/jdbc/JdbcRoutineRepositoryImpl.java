package com.itlbv.routineplanner.repository.jdbc;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.repository.RoutineRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcRoutineRepositoryImpl implements RoutineRepository {
    @Override
    public Routine save(Routine routine) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Routine get(int id) {
        return null;
    }

    @Override
    public List<Routine> getAll() {
        return null;
    }
}
