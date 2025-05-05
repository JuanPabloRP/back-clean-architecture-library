package com.example.demo.infrastructure.usecaseimpl.person;

import com.example.demo.domain.model.Person;
import com.example.demo.domain.repository.PersonRepository;
import com.example.demo.domain.usecase.person.RegisterPersonUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterPersonUseCaseImpl implements RegisterPersonUseCase {

    private final PersonRepository personRepo;

    public Person execute(Person person) {
        return personRepo.save(person);
    }
}