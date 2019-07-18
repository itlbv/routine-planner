package com.itlbv.routineplanner.service;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.util.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static com.itlbv.routineplanner.RoutineTestData.ROUTINES;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration({
        "classpath:/spring/spring-app.xml",
        "classpath:/spring/spring-db.xml"
})
@ExtendWith(SpringExtension.class)
@Sql(scripts = "classpath:/db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class RoutineServiceImplTest {

    static {
        // needed only for java.util.logging (postgres driver)
        SLF4JBridgeHandler.install();
    }

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
        Routine routineExpected = new Routine(100000, "testUpdate");
        Routine routineDB = service.get(100000);
        routineDB.setName("testUpdate");
        service.update(routineDB);
        assertEquals(routineExpected, service.get(100000));
    }

    @Test
    void delete() {
        List<Routine> routinesExpected = new ArrayList<>(ROUTINES);
        routinesExpected.remove(0);
        service.delete(100000);
        assertArrayEquals(routinesExpected.toArray(), service.getAll().toArray());
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> {
            service.delete(0);
        });
    }

    @Test
    void get() {
        assertEquals(ROUTINES.get(0), service.get(100000));
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> {
            service.get(0);
        });
    }

    @Test
    void getAll() {
        assertArrayEquals(ROUTINES.toArray(), service.getAll().toArray());
    }
}