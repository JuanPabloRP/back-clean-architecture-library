package com.example.demo.infrastructure.drivenadapters.adapter.SpringDataJpaRepository;

import com.example.demo.infrastructure.drivenadapters.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialJpaRepository extends JpaRepository<MaterialEntity, String> {

}
