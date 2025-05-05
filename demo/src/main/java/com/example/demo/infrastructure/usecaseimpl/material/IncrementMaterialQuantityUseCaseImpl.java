package com.example.demo.infrastructure.usecaseimpl.material;

import com.example.demo.domain.model.Material;
import com.example.demo.domain.usecase.material.IncrementMaterialQuantityUseCase;
import com.example.demo.infrastructure.drivenadapters.adapter.MaterialRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncrementMaterialQuantityUseCaseImpl implements IncrementMaterialQuantityUseCase {
    private final MaterialRepositoryImpl materialRepo;

    public boolean execute(String materialId, int amount) {
        return Optional.ofNullable(materialRepo.findById(materialId))
                .map(material -> {
                    if (material.isEmpty()) {
                        return false;
                    }
                    Material existingMaterial = material.get();
                    existingMaterial.setTotalQuantity(existingMaterial.getTotalQuantity() + amount);
                    existingMaterial.setAvailableQuantity(existingMaterial.getAvailableQuantity() + amount);
                    materialRepo.save(existingMaterial);
                    return true;
                }).orElse(false);




    }

}
