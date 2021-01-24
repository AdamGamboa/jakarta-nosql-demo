/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jakartanosql;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import javax.json.bind.annotation.JsonbVisibility;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Person implements Serializable {

    @Id
    private String name;

    @Column
    private Integer age;

    @Column
    private Set<String> telephones;

    public Person() {
    }

    public Person(String name, Integer age, Set<String> telephones) {
        this.name = name;
        this.age = age;
        this.telephones = telephones;
    }



    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", telephones=" + telephones +
                '}';
    }
}
