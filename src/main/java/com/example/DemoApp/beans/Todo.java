package com.example.DemoApp.beans;

import java.util.Date;
import java.util.Objects;

public class Todo {
    private long id;
    private String username;
    private String Description;
    private Date targetDate;

    protected Todo()
    {}

    public Todo(long id, String username, String description, Date targetDate) {
        this.id = id;
        this.username = username;
        Description = description;
        this.targetDate = targetDate;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return Description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return (int)id;
    }
}
