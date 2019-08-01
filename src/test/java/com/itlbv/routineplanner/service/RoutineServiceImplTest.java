package com.itlbv.routineplanner.service;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.util.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.itlbv.routineplanner.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

class RoutineServiceImplTest extends AbstractServiceTest {

    @Autowired
    RoutineService service;

    @Test
    void create() {
        Routine routineNew = new Routine(null, USER_1, "routineNew");
        Routine routineDB = service.create(routineNew, USER_1.getId());
        routineNew.setId(routineDB.getId());
        List<Routine> routinesExpected = new ArrayList<>(USER_1_ROUTINES);
        routinesExpected.add(routineNew);
        assertArrayEquals(routinesExpected.toArray(), service.getAll(USER_1.getId()).toArray());
    }

    @Test
    void update() {
        Routine routineExpected = new Routine(100003, USER_1, "testUpdate");
        Routine routineDB = service.get(100003, USER_1.getId());
        routineDB.setName("testUpdate");
        service.update(routineDB, USER_1.getId());
        assertEquals(routineExpected, service.get(100003, USER_1.getId()));
    }

    @Test
    void updateNotFound() {
        Routine routine = service.get(100003, USER_1.getId());
        routine.setName("testUpdate");
        assertThrows(NotFoundException.class, () -> service.update(routine, 0));
    }

    @Test
    void delete() {
        List<Routine> routinesExpected = new ArrayList<>(USER_1_ROUTINES);
        routinesExpected.remove(0);
        service.delete(100003, USER_1.getId());
        assertArrayEquals(routinesExpected.toArray(), service.getAll(USER_1.getId()).toArray());
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(0, USER_1.getId()));
    }

    @Test
    void get() {
        assertEquals(ROUTINES.get(0), service.get(100003, USER_1.getId()));
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(0, USER_1.getId()));
    }

    @Test
    void getAll() {
        assertArrayEquals(USER_1_ROUTINES.toArray(), service.getAll(USER_1.getId()).toArray());
    }
}