package com.itlbv.routineplanner.model;

public class User extends AbstractEntity {

    private String email;

    public User() {
    }

    public User(Integer id, String name) {
        super(id, name);
    }

    public User(Integer id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
