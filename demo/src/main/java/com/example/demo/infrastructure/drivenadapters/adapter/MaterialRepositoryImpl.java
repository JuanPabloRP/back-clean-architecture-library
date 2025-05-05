package com.example.demo.infrastructure.drivenadapters.adapter;


import com.example.demo.domain.model.Material;
import com.example.demo.domain.repository.MaterialRepository;
import com.example.demo.infrastructure.drivenadapters.adapter.SpringDataJpaRepository.MaterialJpaRepository;
import com.example.demo.infrastructure.drivenadapters.entity.MaterialEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MaterialRepositoryImpl implements MaterialRepository {

    private final MaterialJpaRepository materialJpaRepository;

    @Override
    public Material save(Material material) {
        MaterialEntity entity = MaterialEntity.fromMaterial(material);
        return materialJpaRepository.save(entity).toMaterial();
    }

    @Override
    public Optional<Material> findById(String id) {
        return materialJpaRepository.findById(id).map(MaterialEntity::toMaterial);
    }

    @Override
    public List<Material> findAll() {
        return materialJpaRepository.findAll().stream()
                .map(MaterialEntity::toMaterial)
                .toList();
    }

    @Override
    public void deleteById(String id) {
        materialJpaRepository.deleteById(id);
    }
}