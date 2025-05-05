package com.example.demo.domain.model;

import com.example.demo.infrastructure.helpers.MovementType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Movement {
    private Long id;
    private Person person;
    private Material material;
    private LocalDate date;
    private MovementType type;
}
