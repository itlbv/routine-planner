package com.itlbv.routineplanner.service;

import com.itlbv.routineplanner.model.User;
import com.itlbv.routineplanner.repository.UserRepository;
import com.itlbv.routineplanner.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!repository.delete(id)) {
            throw new NotFoundException("Failed deleting user with id=" + id);
        }
    }

    @Override
    public User get(int id) throws NotFoundException {
        User user = repository.get(id);
        if (user == null) {
            throw new NotFoundException("Not found user with id=" + id);
        }
        return user;
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        User user = repository.getByEmail(email);
        if (user == null) {
            throw new NotFoundException("Not found user with email=" + email);
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
