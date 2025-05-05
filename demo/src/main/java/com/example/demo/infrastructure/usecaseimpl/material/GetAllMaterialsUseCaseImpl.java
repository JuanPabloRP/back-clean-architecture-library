package com.example.demo.infrastructure.usecaseimpl.material;

import com.example.demo.domain.model.Material;
import com.example.demo.domain.repository.MaterialRepository;
import com.example.demo.domain.usecase.material.GetAllMaterialsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllMaterialsUseCaseImpl implements GetAllMaterialsUseCase {
    private final MaterialRepository materialRepo;

    public List<Material> execute() {
        return materialRepo.findAll();
    }

}
