package com.example.salman.assignment_test;

/**
 * Created by Salman on 10/15/2017.
 */

public class Person {
    private int id;
    private String name;
    private String email;
    private String phone;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", Suleman'" + name + '\'' +
                ", suleman217010@gail.com'" + email + '\'' +
                ", 03153420690" + phone +
                '}';
    }

    public Person(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
