package com.example.demo.infrastructure.usecaseimpl.material;

import com.example.demo.domain.model.Material;
import com.example.demo.domain.repository.MaterialRepository;
import com.example.demo.domain.usecase.material.FindMaterialFindByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class FindMaterialFindByIdUseCaseImpl implements FindMaterialFindByIdUseCase {
    private final MaterialRepository materialRepo;

    public Material execute(String materialId) {
        return materialRepo.findById(materialId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Material not found"));
    }
}
