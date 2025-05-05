package com.example.demo.infrastructure.usecaseimpl.material;

import com.example.demo.domain.model.Material;
import com.example.demo.domain.repository.MaterialRepository;
import com.example.demo.domain.usecase.material.RegisterMaterialUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterMaterialUseCaseImpl implements RegisterMaterialUseCase {
    private final MaterialRepository materialRepo;

    public Material execute(Material material) {
        return materialRepo.save(material);
    }

}
