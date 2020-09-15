package ru.jurfed.springwebflux.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Person {


    public Person(int id, String name, String surname) {
        this.id = id;
        this.surname = surname;
    }


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person() {
    }

    @Id
    @Column("person_id")
    private int id;

    @Column("person_name")
    private String name;

    @Column("person_surname")
    private String surname;


    public Person(String name) {
        this.name = name;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
