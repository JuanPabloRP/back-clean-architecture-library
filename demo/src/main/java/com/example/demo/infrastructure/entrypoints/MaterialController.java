package com.example.demo.infrastructure.entrypoints;


import com.example.demo.domain.model.Material;
import com.example.demo.domain.repository.MaterialRepository;
import com.example.demo.domain.usecase.material.FindMaterialFindByIdUseCase;
import com.example.demo.domain.usecase.material.GetAllMaterialsUseCase;
import com.example.demo.domain.usecase.material.IncrementMaterialQuantityUseCase;
import com.example.demo.domain.usecase.material.RegisterMaterialUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/material")
@RequiredArgsConstructor
public class MaterialController {

    private final RegisterMaterialUseCase registerMaterialUseCase;
    private final GetAllMaterialsUseCase getAllMaterialsUseCase;
    private final IncrementMaterialQuantityUseCase incrementMaterialQuantityUseCase;


    @GetMapping
    public List<Material> getAllMaterials() {
        return getAllMaterialsUseCase.execute();
    }

    @PostMapping
    public Material registerMaterial(@RequestBody Material material) {
        return registerMaterialUseCase.execute(material);
    }

    @PostMapping("/{id}/increment")
    public boolean incrementMaterial(@PathVariable String id, @RequestParam int amount) {
        return incrementMaterialQuantityUseCase.execute(id, amount);
    }
}
