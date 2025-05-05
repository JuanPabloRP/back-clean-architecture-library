package com.example.demo.infrastructure.entrypoints;

import com.example.demo.domain.model.Material;
import com.example.demo.domain.model.Movement;
import com.example.demo.domain.model.Person;
import com.example.demo.domain.usecase.movement.MovementUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movement")
public class MovementController {

    private final MovementUseCase movementUseCase;
    private final PersonUseCase personUseCase;
    private final MaterialUseCase materialUseCase;

    public MovementController(MovementUseCase movementUseCase, PersonUseCase personUseCase, MaterialUseCase materialUseCase) {
        this.movementUseCase = movementUseCase;
        this.personUseCase = personUseCase;
        this.materialUseCase = materialUseCase;
    }


    @PostMapping("/borrow")
    public boolean borrowMaterial(@RequestParam String personId, @RequestParam String materialId) {
        Person person = personUseCase.findById(personId);
        Material material = materialUseCase.findById(materialId);

        boolean result = movementUseCase.borrowMaterial(person, material);
        if (result) {
            personUseCase.registerPerson(person);
            materialUseCase.registerMaterial(material);
        }
        return result;
    }

    @PostMapping("/return")
    public boolean returnMaterial(@RequestParam String personId, @RequestParam String materialId) {
        Person person = personUseCase.findById(personId);
        Material material = materialUseCase.findById(materialId);

        boolean result = movementUseCase.returnMaterial(person, material);
        if (result) {
            personUseCase.registerPerson(person);
            materialUseCase.registerMaterial(material);
        }
        return result;
    }


    @GetMapping("/history")
    public List<Movement> getHistory() {
        return movementUseCase.getLibraryHistory();
    }
}
