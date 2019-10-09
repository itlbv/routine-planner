package com.itlbv.routineplanner.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Routine extends AbstractEntity {

    private User user;
    private String description;
    private LocalDate startDate, endDate;
    private LocalTime timeOfDay;
    private Period period;


    public Routine() {
    }

    public Routine(Integer id, User user, String name, String description,
                   LocalDate startDate, LocalDate endDate, LocalTime timeOfDay, Period period) {
        super(id, name);
        this.user = user;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeOfDay = timeOfDay;
        this.period = period;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(LocalTime timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}