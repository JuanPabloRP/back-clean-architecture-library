package com.example.demo.domain.usecase.person;

import com.example.demo.domain.model.Person;
import com.example.demo.domain.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

public interface RegisterPersonUseCase {
    Person execute(Person person);
}