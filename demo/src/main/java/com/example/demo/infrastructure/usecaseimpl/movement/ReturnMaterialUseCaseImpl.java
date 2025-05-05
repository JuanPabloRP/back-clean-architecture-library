package com.example.demo.infrastructure.usecaseimpl.movement;

import com.example.demo.domain.model.Material;
import com.example.demo.domain.model.Movement;
import com.example.demo.domain.model.Person;
import com.example.demo.domain.repository.MovementRepository;
import com.example.demo.domain.usecase.movement.ReturnMaterialUseCase;
import com.example.demo.infrastructure.helpers.MovementType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReturnMaterialUseCaseImpl implements ReturnMaterialUseCase {

    private final MovementRepository movementRepo;

    public boolean execute(Person person, Material material) {
        if (person.getBorrowedMaterials().contains(material)) {
            person.getBorrowedMaterials().remove(material);
            material.setAvailableQuantity(material.getAvailableQuantity() + 1);

            movementRepo.save(
                    Movement
                            .builder()
                            .person(person)
                            .material(material)
                            .type(MovementType.RETURN)
                            .date(LocalDate.now())
                            .build()
            );
            return true;
        }
        return false;
    }
}