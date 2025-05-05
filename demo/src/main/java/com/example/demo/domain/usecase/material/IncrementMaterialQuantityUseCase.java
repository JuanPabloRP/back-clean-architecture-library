package com.example.demo.domain.usecase.material;


public interface IncrementMaterialQuantityUseCase {
    boolean execute(String materialId, int amount);
}
