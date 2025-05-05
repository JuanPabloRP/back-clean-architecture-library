package com.example.demo.domain.usecase.movement;

import com.example.demo.domain.model.Material;
import com.example.demo.domain.model.Person;

public interface ReturnMaterialUseCase {
    boolean execute(Person person, Material material);
}