package com.example.demo.domain.usecase.person;

import com.example.demo.domain.model.Person;
import com.example.demo.domain.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

public interface DeletePersonUseCase {
    boolean execute(String idCard);
}
