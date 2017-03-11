package com.may.bookslib.model;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private long id;
    private String name;
    private String password;

    public Student() {

    }

    public Student(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
