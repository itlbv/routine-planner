package com.itlbv.routineplanner;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestData {
    private static final AtomicInteger GLOBAL_START_SEQ = new AtomicInteger(100000);
    public static final List<User> USERS = new ArrayList<>(populateUsers());
    public static final User USER_1 = USERS.get(0);
    public static final List<Routine> ROUTINES = new ArrayList<>(populateRoutines());
    public static final List<Routine> USER_1_ROUTINES = new ArrayList<>(populateUser01Routines());

    private static List<User> populateUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(GLOBAL_START_SEQ.getAndIncrement(), "user1", "email1@gmail.com", LocalDateTime.of(2001, 1, 1, 0, 0)));
        users.add(new User(GLOBAL_START_SEQ.getAndIncrement(), "user2", "email2@hotmail.no", LocalDateTime.of(2001, 1, 1, 0, 0)));
        users.add(new User(GLOBAL_START_SEQ.getAndIncrement(), "user3", "email3@yandex.ru", LocalDateTime.of(2001, 1, 1, 0, 0)));
        return users;
    }

    private static List<Routine> populateRoutines() {
        List<Routine> routines = new ArrayList<>();
        routines.add(new Routine(GLOBAL_START_SEQ.getAndIncrement(), "routine1_1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", LocalDate.of(2001, 1, 5), LocalDate.of(2001, 10, 5), LocalTime.of(1, 0), Period.ofDays(2)));
        routines.add(new Routine(GLOBAL_START_SEQ.getAndIncrement(), "routine2_1", "Lorem ipsum", LocalDate.of(2001, 1, 5), LocalDate.of(2001, 10, 5), LocalTime.of(2, 0), Period.ofDays(2)));
        routines.add(new Routine(GLOBAL_START_SEQ.getAndIncrement(), "routine3_1", "Lorem ipsum", LocalDate.of(2001, 1, 5), LocalDate.of(2001, 10, 5), LocalTime.of(3, 0), Period.ofDays(2)));
        routines.add(new Routine(GLOBAL_START_SEQ.getAndIncrement(), "routine1_2", "Lorem ipsum", LocalDate.of(2001, 1, 5), LocalDate.of(2001, 10, 5), LocalTime.of(4, 0), Period.ofDays(2)));
        routines.add(new Routine(GLOBAL_START_SEQ.getAndIncrement(), "routine2_2", "Lorem ipsum", LocalDate.of(2001, 1, 5), LocalDate.of(2001, 10, 5), LocalTime.of(12, 0), Period.ofDays(2)));
        routines.add(new Routine(GLOBAL_START_SEQ.getAndIncrement(), "routine3_2", "Lorem ipsum", LocalDate.of(2001, 1, 5), LocalDate.of(2001, 10, 5), LocalTime.of(13, 0), Period.ofDays(2)));
        routines.add(new Routine(GLOBAL_START_SEQ.getAndIncrement(), "routine1_3", "Lorem ipsum", LocalDate.of(2001, 1, 5), LocalDate.of(2001, 10, 5), LocalTime.of(10, 0), Period.ofDays(2)));
        routines.add(new Routine(GLOBAL_START_SEQ.getAndIncrement(), "routine2_3", "Lorem ipsum", LocalDate.of(2001, 1, 5), LocalDate.of(2001, 10, 5), LocalTime.of(11, 0), Period.ofDays(2)));
        routines.add(new Routine(GLOBAL_START_SEQ.getAndIncrement(), "routine3_3", "Lorem ipsum", LocalDate.of(2001, 1, 5), LocalDate.of(2001, 10, 5), LocalTime.of(5, 0), Period.ofDays(2)));
        return routines;
    }

    private static List<Routine> populateUser01Routines() {
        List<Routine> user01Routines = new ArrayList<>();
        user01Routines.add(ROUTINES.get(0));
        user01Routines.add(ROUTINES.get(1));
        user01Routines.add(ROUTINES.get(2));
        return user01Routines;
    }

    public static Routine createTestRoutine(Integer id, User user, String name) {
        return new Routine(id, name, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", LocalDate.of(2001, 1, 5), LocalDate.of(2001, 10, 5), LocalTime.of(1, 0), Period.ofDays(2));
    }

    public static User createTestUser(Integer id, String name, String email) {
        return new User(id, name, email, LocalDateTime.of(2001, 1, 1, 0, 0));
    }
}
