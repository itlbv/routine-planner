package com.itlbv.routineplanner;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestData {
    private static final AtomicInteger GLOBAL_START_SEQ = new AtomicInteger(100000);
    public static final List<User> USERS = new ArrayList<>(populateUsers());
    public static final List<Routine> ROUTINES = new ArrayList<>(populateRoutines());

    private static List<User> populateUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(GLOBAL_START_SEQ.getAndIncrement(), "user1", "email1"));
        users.add(new User(GLOBAL_START_SEQ.getAndIncrement(), "user2", "email2"));
        users.add(new User(GLOBAL_START_SEQ.getAndIncrement(), "user3", "email3"));
        return users;
    }

    private static List<Routine> populateRoutines() {
        List<Routine> routines = new ArrayList<>();
        routines.add(new Routine(GLOBAL_START_SEQ.getAndIncrement(), "routine1"));
        routines.add(new Routine(GLOBAL_START_SEQ.getAndIncrement(), "routine2"));
        routines.add(new Routine(GLOBAL_START_SEQ.getAndIncrement(), "routine3"));
        return routines;
    }
}
