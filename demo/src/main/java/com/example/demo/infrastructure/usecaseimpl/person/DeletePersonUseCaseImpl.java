package com.example.demo.infrastructure.usecaseimpl.person;

import com.example.demo.domain.model.Person;
import com.example.demo.domain.repository.PersonRepository;
import com.example.demo.domain.usecase.person.DeletePersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DeletePersonUseCaseImpl implements DeletePersonUseCase {

    private final PersonRepository personRepo;

    public boolean execute(String idCard) {
        Person person = personRepo.findById(idCard).orElse(null);
        if (!Objects.isNull(person) && person.getBorrowedMaterials().isEmpty()) {
            personRepo.deleteById(person.getIdCard());
            return true;
        }
        return false;
    }
}
