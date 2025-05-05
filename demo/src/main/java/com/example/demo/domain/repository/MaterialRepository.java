package com.example.demo.domain.repository;


import com.example.demo.domain.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MaterialRepository  {
    Material save(Material material);
    Optional<Material> findById(String id);
    List<Material> findAll();
    void deleteById(String id);
}

