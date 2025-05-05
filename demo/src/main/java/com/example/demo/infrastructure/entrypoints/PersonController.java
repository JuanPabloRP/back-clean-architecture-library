package com.example.demo.infrastructure.entrypoints;

import com.example.demo.domain.model.Person;
import com.example.demo.domain.usecase.person.DeletePersonUseCase;
import com.example.demo.domain.usecase.person.RegisterPersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    RegisterPersonUseCase registerPersonUseCase;
    DeletePersonUseCase deletePersonUseCase;

    @PostMapping
    public Person registerPerson(@RequestBody Person person) {
        return registerPersonUseCase.execute(person);
    }

    @DeleteMapping("/{idCard}")
    public boolean deletePerson(@PathVariable String idCard) {
        return deletePersonUseCase.execute(idCard);
    }
}