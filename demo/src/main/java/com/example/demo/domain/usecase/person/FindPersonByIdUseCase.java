package com.example.demo.domain.usecase.person;

import com.example.demo.domain.model.Person;

public interface FindPersonByIdUseCase {
    Person execute(String idCard);
}
