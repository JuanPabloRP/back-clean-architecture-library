package com.example.demo.domain.usecase.person;

import com.example.demo.domain.model.Person;

public interface RegisterPersonUseCase {
    Person execute(Person person);
}