package com.itlbv.routineplanner.model;

public abstract class AbstractEntity {
    private Integer id;
    private String name;

    AbstractEntity() {

    }

    AbstractEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNew() {
        return (getId() == null);
    }
}
