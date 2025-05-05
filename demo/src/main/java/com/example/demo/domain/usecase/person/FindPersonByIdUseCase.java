package com.example.demo.domain.usecase.person;

import com.example.demo.domain.model.Person;
import com.example.demo.domain.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface FindPersonByIdUseCase {
    Person execute(String idCard);
}
