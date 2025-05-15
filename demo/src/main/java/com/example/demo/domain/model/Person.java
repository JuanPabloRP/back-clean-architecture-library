package com.example.demo.domain.model;

import com.example.demo.infrastructure.helpers.Role;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Person {
    private String idCard;
    private String name;
    private Role role;

    @Builder.Default
    private List<Material> borrowedMaterials = List.of();

}