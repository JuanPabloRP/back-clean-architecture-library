package com.example.demo.infrastructure.drivenadapters.entity;

import com.example.demo.domain.model.Person;
import com.example.demo.infrastructure.helpers.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonEntity {

    @Id
    private String idCard;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    private List<MaterialEntity> borrowedMaterials;

    public Person toPerson() {
        return Person.builder()
                .idCard(idCard)
                .name(name)
                .role(role)
                .borrowedMaterials(
                        borrowedMaterials.stream()
                                .map(MaterialEntity::toMaterial)
                                .collect(Collectors.toList()))
                .build();
    }

    public static PersonEntity fromPerson(Person person) {
        return PersonEntity.builder()
                .idCard(person.getIdCard())
                .name(person.getName())
                .role(person.getRole())
                .borrowedMaterials(
                        person.getBorrowedMaterials().stream()
                                .map(MaterialEntity::fromMaterial)
                                .collect(Collectors.toList()))
                .build();
    }
}
