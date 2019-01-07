package io.zipcoder.crudapp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Person {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    public Person(){}

    public Person(String firstName, String lastName, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
