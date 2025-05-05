package com.example.demo.infrastructure.drivenadapters.adapter;

import com.example.demo.domain.model.Person;
import com.example.demo.domain.repository.PersonRepository;
import com.example.demo.infrastructure.drivenadapters.adapter.SpringDataJpaRepository.PersonJpaRepository;
import com.example.demo.infrastructure.drivenadapters.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private final PersonJpaRepository personJpaRepository;

    @Override
    public Person save(Person person) {
        return personJpaRepository.save(PersonEntity.fromPerson(person)).toPerson();
    }

    @Override
    public Optional<Person> findById(String idCard) {
        return personJpaRepository.findById(idCard).map(PersonEntity::toPerson);
    }

    @Override
    public List<Person> findAll() {
        return personJpaRepository.findAll().stream()
                .map(PersonEntity::toPerson)
                .toList();
    }

    @Override
    public void deleteById(String idCard) {
        personJpaRepository.deleteById(idCard);
    }
}