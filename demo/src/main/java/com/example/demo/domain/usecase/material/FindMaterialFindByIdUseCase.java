package com.example.demo.domain.usecase.material;

import com.example.demo.domain.model.Material;


public interface FindMaterialFindByIdUseCase {
    Material execute(String materialId);
}
