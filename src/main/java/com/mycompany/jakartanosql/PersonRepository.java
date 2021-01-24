package com.mycompany.jakartanosql;

import jakarta.nosql.mapping.Page;
import jakarta.nosql.mapping.Pagination;
import jakarta.nosql.mapping.Repository;

import java.util.stream.Stream;

public interface PersonRepository extends Repository<Person, String> {

    Stream<Person> findAll();

    Page<Person> findAll(Pagination pagination);

    Stream<Person> findByTelephonesIn(String telephones);

    Stream<Person> findByAgeGreaterThan(Integer age);

    Stream<Person> findByAgeLessThan(Integer age);
}
