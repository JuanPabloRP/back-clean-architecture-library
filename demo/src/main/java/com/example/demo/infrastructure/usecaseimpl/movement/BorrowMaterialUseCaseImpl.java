package com.example.demo.infrastructure.usecaseimpl.movement;


import com.example.demo.domain.model.Material;
import com.example.demo.domain.model.Movement;
import com.example.demo.domain.model.Person;
import com.example.demo.domain.repository.MovementRepository;
import com.example.demo.domain.usecase.movement.BorrowMaterialUseCase;
import com.example.demo.infrastructure.helpers.MovementType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BorrowMaterialUseCaseImpl implements BorrowMaterialUseCase {

    private final MovementRepository movementRepo;

    public boolean execute(Person person, Material material) {
        if (material.getAvailableQuantity() > 0) {
            int limit = switch (person.getRole()) {
                case STUDENT -> 5;
                case PROFESSOR -> 3;
                case ADMINISTRATIVE -> 1;
            };
            if (person.getBorrowedMaterials().size() >= limit) return false;

            person.getBorrowedMaterials().add(material);
            material.setAvailableQuantity(material.getAvailableQuantity() - 1);

            movementRepo.save(
                    Movement
                            .builder()
                            .person(person)
                            .material(material)
                            .date(LocalDate.now())
                            .type(MovementType.BORROW)
                    .build());
            return true;
        }
        return false;
    }
}