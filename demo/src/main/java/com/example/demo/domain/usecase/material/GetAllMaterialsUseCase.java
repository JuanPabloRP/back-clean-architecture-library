package com.example.demo.domain.usecase.material;

import com.example.demo.domain.model.Material;

import java.util.List;


public interface GetAllMaterialsUseCase {
    List<Material> execute();
}
