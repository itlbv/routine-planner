package com.itlbv.routineplanner.model;

public class Routine extends AbstractEntity {

    private User user;

    public Routine() {
    }

    public Routine(Integer id, User user, String name) {
        super(id, name);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}