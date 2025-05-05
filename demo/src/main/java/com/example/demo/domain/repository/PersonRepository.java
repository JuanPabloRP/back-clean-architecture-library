package com.example.demo.domain.repository;

import com.example.demo.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Person save(Person person);
    Optional<Person> findById(String idCard);
    List<Person> findAll();
    void deleteById(String idCard);
}
