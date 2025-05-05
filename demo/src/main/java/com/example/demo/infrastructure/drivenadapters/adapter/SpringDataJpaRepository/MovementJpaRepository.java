package com.example.demo.infrastructure.drivenadapters.adapter.SpringDataJpaRepository;

import com.example.demo.infrastructure.drivenadapters.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementJpaRepository extends JpaRepository<MovementEntity, Long> {
}
