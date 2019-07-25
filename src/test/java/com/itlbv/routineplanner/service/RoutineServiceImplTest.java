package com.itlbv.routineplanner.service;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.util.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.itlbv.routineplanner.TestData.ROUTINES;
import static org.junit.jupiter.api.Assertions.*;

class RoutineServiceImplTest extends AbstractServiceTest {

    @Autowired
    RoutineService service;

    @Test
    void create() {
        Routine routineNew = new Routine(null, "routineNew");
        Routine routineDB = service.create(routineNew);
        routineNew.setId(routineDB.getId());
        List<Routine> routinesExpected = new ArrayList<>(ROUTINES);
        routinesExpected.add(routineNew);
        assertArrayEquals(routinesExpected.toArray(), service.getAll().toArray());
    }

    @Test
    void update() {
        Routine routineExpected = new Routine(100003, "testUpdate");
        Routine routineDB = service.get(100003);
        routineDB.setName("testUpdate");
        service.update(routineDB);
        assertEquals(routineExpected, service.get(100003));
    }

    @Test
    void delete() {
        List<Routine> routinesExpected = new ArrayList<>(ROUTINES);
        routinesExpected.remove(0);
        service.delete(100003);
        assertArrayEquals(routinesExpected.toArray(), service.getAll().toArray());
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(0));
    }

    @Test
    void get() {
        assertEquals(ROUTINES.get(0), service.get(100003));
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(0));
    }

    @Test
    void getAll() {
        assertArrayEquals(ROUTINES.toArray(), service.getAll().toArray());
    }
}