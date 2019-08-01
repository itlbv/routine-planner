package com.itlbv.routineplanner.service;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.repository.RoutineRepository;
import com.itlbv.routineplanner.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineServiceImpl implements RoutineService {

    private final RoutineRepository repository;

    @Autowired
    public RoutineServiceImpl(RoutineRepository repository) {
        this.repository = repository;
    }

    @Override
    public Routine create(Routine routine, int userId) {
        return repository.save(routine, userId);
    }

    @Override
    public void update(Routine routine, int userId) throws NotFoundException {
        if (repository.save(routine, userId) == null) {
            throw new NotFoundException("Failed updating routine with id=" + routine.getId());
        }
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        if (!repository.delete(id, userId)) {
            throw new NotFoundException("Failed deleting routine with id=" + id);
        }
    }

    @Override
    public Routine get(int id, int userId) throws NotFoundException {
        Routine routine = repository.get(id, userId);
        if (routine == null) {
            throw new NotFoundException("Not found routine with id=" + id);
        }
        return routine;
    }

    @Override
    public List<Routine> getAll(int userId) {
        return repository.getAll(userId);
    }
}
