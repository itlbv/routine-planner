package com.itlbv.routineplanner.model;

import java.time.LocalDateTime;

public class User extends AbstractEntity {

    private String email;
    private LocalDateTime registrationDateTime;

    public User() {
    }

    public User(Integer id, String name, String email) {
        super(id, name);
        this.email = email;
        this.registrationDateTime = LocalDateTime.now();
    }

    public User(Integer id, String name, String email, LocalDateTime registrationDateTime) {
        super(id, name);
        this.email = email;
        this.registrationDateTime = registrationDateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (!email.equals(user.email)) return false;
        return registrationDateTime.equals(user.registrationDateTime);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + registrationDateTime.hashCode();
        return result;
    }
}
