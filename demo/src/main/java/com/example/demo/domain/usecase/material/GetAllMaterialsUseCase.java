package com.example.demo.domain.usecase.material;

import com.example.demo.domain.model.Material;
import com.example.demo.domain.repository.MaterialRepository;
import com.example.demo.infrastructure.drivenadapters.adapter.MaterialRepositoryImpl;

import java.util.List;


public interface GetAllMaterialsUseCase {
    List<Material> execute();
}
