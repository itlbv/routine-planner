package com.itlbv.routineplanner.repository;

import com.itlbv.routineplanner.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    boolean delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();
}
