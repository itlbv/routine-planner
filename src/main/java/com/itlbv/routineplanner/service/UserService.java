package com.itlbv.routineplanner.service;

import com.itlbv.routineplanner.model.User;
import com.itlbv.routineplanner.util.NotFoundException;

import java.util.List;

public interface UserService {

    User create(User user);

    void update(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();
}
