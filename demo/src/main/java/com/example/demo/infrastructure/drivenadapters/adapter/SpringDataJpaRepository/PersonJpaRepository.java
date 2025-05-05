package com.example.demo.infrastructure.drivenadapters.adapter.SpringDataJpaRepository;

import com.example.demo.infrastructure.drivenadapters.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, String> {
}
