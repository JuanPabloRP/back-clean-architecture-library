package com.example.demo.domain.usecase.movement;

import com.example.demo.domain.model.Movement;
import com.example.demo.domain.repository.MovementRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

public interface GetLibraryHistoryUseCase {
    List<Movement> execute();
}