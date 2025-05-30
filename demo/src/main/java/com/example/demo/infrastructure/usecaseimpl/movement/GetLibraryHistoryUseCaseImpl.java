package com.example.demo.infrastructure.usecaseimpl.movement;

import com.example.demo.domain.model.Movement;
import com.example.demo.domain.repository.MovementRepository;
import com.example.demo.domain.usecase.movement.GetLibraryHistoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetLibraryHistoryUseCaseImpl  implements GetLibraryHistoryUseCase {

    private final MovementRepository movementRepo;

    public List<Movement> execute() {
        return movementRepo.findAll();
    }
}