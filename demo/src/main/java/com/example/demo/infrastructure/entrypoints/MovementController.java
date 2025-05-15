package com.example.demo.infrastructure.entrypoints;

import com.example.demo.domain.model.Material;
import com.example.demo.domain.model.Movement;
import com.example.demo.domain.model.Person;
import com.example.demo.domain.usecase.material.FindMaterialFindByIdUseCase;
import com.example.demo.domain.usecase.material.RegisterMaterialUseCase;
import com.example.demo.domain.usecase.movement.BorrowMaterialUseCase;
import com.example.demo.domain.usecase.movement.GetLibraryHistoryUseCase;
import com.example.demo.domain.usecase.movement.ReturnMaterialUseCase;
import com.example.demo.domain.usecase.person.FindPersonByIdUseCase;
import com.example.demo.domain.usecase.person.RegisterPersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movement")
@RequiredArgsConstructor
public class MovementController {

    private final FindPersonByIdUseCase findPersonByIdUseCase;
    private final RegisterPersonUseCase registerPersonUseCase;

    private final FindMaterialFindByIdUseCase findMaterialFindByIdUseCase;
    private final RegisterMaterialUseCase registerMaterialUseCase;

    private final BorrowMaterialUseCase borrowMaterialUseCase;
    private final ReturnMaterialUseCase returnMaterialUseCase;
    private final GetLibraryHistoryUseCase getLibraryHistoryUseCase;


    @PostMapping("/borrow")
    public boolean borrowMaterial(@RequestParam String personId, @RequestParam String materialId) {
        Person person = findPersonByIdUseCase.execute(personId);
        Material material = findMaterialFindByIdUseCase.execute(materialId);

        boolean result = borrowMaterialUseCase.execute(person, material);
        if (result) {
            registerPersonUseCase.execute(person);
            registerMaterialUseCase.execute(material);
        }
        return result;
    }

    @PostMapping("/return")
    public boolean returnMaterial(@RequestParam String personId, @RequestParam String materialId) {
        Person person = findPersonByIdUseCase.execute(personId);
        Material material = findMaterialFindByIdUseCase.execute(materialId);

        boolean result = returnMaterialUseCase.execute(person, material);
        if (result) {
            registerPersonUseCase.execute(person);
            registerMaterialUseCase.execute(material);
        }
        return result;
    }


    @GetMapping("/history")
    public List<Movement> getHistory() {
        return getLibraryHistoryUseCase.execute();
    }
}
