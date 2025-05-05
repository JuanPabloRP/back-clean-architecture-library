package com.example.demo.infrastructure.usecaseimpl.person;

import com.example.demo.domain.model.Person;
import com.example.demo.domain.repository.PersonRepository;
import com.example.demo.domain.usecase.person.FindPersonByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
public class FindPersonByIdUseCaseImpl implements FindPersonByIdUseCase {

    private final PersonRepository personRepo;

    public Person execute(String idCard) {
        return personRepo.findById(idCard)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"));
    }
}
