package com.example.demo.infrastructure.drivenadapters.entity;

import com.example.demo.domain.model.Material;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialEntity {

    @Id
    private String id;
    private String title;
    private LocalDate registrationDate;
    private int totalQuantity;
    private int availableQuantity;

    public Material toMaterial() {
        return Material.builder()
                .id(id)
                .title(title)
                .registrationDate(registrationDate)
                .totalQuantity(totalQuantity)
                .availableQuantity(availableQuantity)
                .build();
    }

    public static MaterialEntity fromMaterial(Material material) {
        return MaterialEntity.builder()
                .id(material.getId())
                .title(material.getTitle())
                .registrationDate(material.getRegistrationDate())
                .totalQuantity(material.getTotalQuantity())
                .availableQuantity(material.getAvailableQuantity())
                .build();
    }
}
