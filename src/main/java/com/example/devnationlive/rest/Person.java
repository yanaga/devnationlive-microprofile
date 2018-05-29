package com.example.devnationlive.rest;

public class Person {

    private int id;

    private String name;

    public Person() {
    }

    private Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Person of(int id, String name) {
        return new Person(id, name);
    }

    public int getId() {
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
}
