package com.example.demo.domain.usecase.material;

import com.example.demo.domain.model.Material;
import com.example.demo.infrastructure.drivenadapters.adapter.MaterialRepositoryImpl;

import java.util.Objects;
import java.util.Optional;

public interface IncrementMaterialQuantityUseCase {
    boolean execute(String materialId, int amount);
}
