package com.itlbv.routineplanner.service;

import com.itlbv.routineplanner.model.User;
import com.itlbv.routineplanner.util.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.itlbv.routineplanner.TestData.USERS;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest extends AbstractServiceTest {

    @Autowired
    UserService service;

    @Test
    void create() {
        User userNew = new User(null, "userNew", "emailNew");
        User userDB = service.create(userNew);
        userNew.setId(userDB.getId());
        List<User> usersExpected = new ArrayList<>(USERS);
        usersExpected.add(userNew);
        assertArrayEquals(usersExpected.toArray(), service.getAll().toArray());
    }

    @Test
    void update() {
        User userExpected = new User(100000, "testUpdate", "email1");
        User userDB = service.get(100000);
        userDB.setName("testUpdate");
        service.update(userDB);
        assertEquals(userExpected, service.get(100000));
    }

    @Test
    void delete() {
        List<User> usersExpected = new ArrayList<>(USERS);
        usersExpected.remove(0);
        service.delete(100000);
        assertArrayEquals(usersExpected.toArray(), service.getAll().toArray());
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(0));
    }

    @Test
    void get() {
        assertEquals(USERS.get(0), service.get(100000));
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(0));
    }

    @Test
    void getByEmail() {
        User userExpected = USERS.get(0);
        User userDB = service.getByEmail("email1");
        assertEquals(userExpected, userDB);
    }

    @Test
    void getByEmailNotFound() {
        assertThrows(NotFoundException.class, () -> service.getByEmail("nonexistent email"));
    }

    @Test
    void getAll() {
        assertArrayEquals(USERS.toArray(), service.getAll().toArray());
    }
}