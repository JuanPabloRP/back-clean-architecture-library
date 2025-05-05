package com.example.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Material {
    private String id;
    private String title;
    private LocalDate registrationDate;
    private int totalQuantity;
    private int availableQuantity;
}
