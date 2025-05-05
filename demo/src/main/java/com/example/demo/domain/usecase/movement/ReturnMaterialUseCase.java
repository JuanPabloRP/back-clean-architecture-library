package com.example.demo.domain.usecase.movement;

import com.example.demo.domain.model.Material;
import com.example.demo.domain.model.Movement;
import com.example.demo.domain.model.Person;
import com.example.demo.domain.repository.MovementRepository;
import com.example.demo.infrastructure.helpers.MovementType;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

public interface ReturnMaterialUseCase {
    boolean execute(Person person, Material material);
}