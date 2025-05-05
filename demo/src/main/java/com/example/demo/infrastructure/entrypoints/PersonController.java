package com.example.demo.infrastructure.entrypoints;

import com.example.demo.domain.model.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonUseCase personUseCase;

    public PersonController(PersonUseCase personUseCase) {
        this.personUseCase = personUseCase;
    }

    @PostMapping
    public Person registerPerson(@RequestBody Person person) {
        return personUseCase.registerPerson(person);
    }

    @DeleteMapping("/{idCard}")
    public boolean deletePerson(@PathVariable String idCard) {
        return personUseCase.deletePerson(idCard);
    }
}