package com.example.demo.infrastructure.drivenadapters.entity;

import com.example.demo.domain.model.Movement;
import com.example.demo.infrastructure.helpers.MovementType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PersonEntity person;

    @ManyToOne
    private MaterialEntity material;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private MovementType type;

    public Movement toMovement() {
        return Movement.builder()
                .id(id)
                .person(person.toPerson())
                .material(material.toMaterial())
                .date(date)
                .type(type)
                .build();
    }

    public static MovementEntity fromMovement(Movement movement) {
        return MovementEntity.builder()
                .id(movement.getId())
                .person(PersonEntity.fromPerson(movement.getPerson()))
                .material(MaterialEntity.fromMaterial(movement.getMaterial()))
                .date(movement.getDate())
                .type(movement.getType())
                .build();
    }
}
