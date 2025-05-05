package com.example.demo.infrastructure.drivenadapters.adapter;

import com.example.demo.domain.model.Movement;
import com.example.demo.domain.repository.MovementRepository;
import com.example.demo.infrastructure.drivenadapters.adapter.SpringDataJpaRepository.MovementJpaRepository;
import com.example.demo.infrastructure.drivenadapters.entity.MovementEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovementRepositoryImpl implements MovementRepository {

    private final MovementJpaRepository movementJpaRepository;

    @Override
    public Movement save(Movement movement) {
        return movementJpaRepository.save(MovementEntity.fromMovement(movement)).toMovement();
    }

    @Override
    public Optional<Movement> findById(Long id) {
        return movementJpaRepository.findById(id).map(MovementEntity::toMovement);
    }

    @Override
    public List<Movement> findAll() {
        return movementJpaRepository.findAll().stream()
                .map(MovementEntity::toMovement)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        movementJpaRepository.deleteById(id);
    }
}
