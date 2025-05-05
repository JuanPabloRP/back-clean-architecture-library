package com.example.demo.domain.repository;

import com.example.demo.domain.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovementRepository {
    Movement save(Movement movement);
    Optional<Movement> findById(Long id);
    List<Movement> findAll();
    void deleteById(Long id);
}
