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
    public Routine create(Routine routine) {
        return repository.save(routine);
    }

    @Override
    public void update(Routine routine) {
        repository.save(routine);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!repository.delete(id)) {
            throw new NotFoundException("Failed deleting routine with id=" + id);
        }
    }

    @Override
    public Routine get(int id) throws NotFoundException {
        Routine routine = repository.get(id);
        if (routine == null) {
            throw new NotFoundException("Not found routine with id=" + id);
        }
        return routine;
    }

    @Override
    public List<Routine> getAll() {
        return repository.getAll();
    }
}
