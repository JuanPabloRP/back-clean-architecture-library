package com.example.demo.infrastructure.drivenadapters.entity;

import com.example.demo.domain.model.Material;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate registrationDate;
    private int totalQuantity;
    private int availableQuantity;


    @PrePersist
    protected void onCreate() {
        this.registrationDate = LocalDate.now();
    }

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
