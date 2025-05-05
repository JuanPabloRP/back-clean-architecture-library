package com.example.demo.domain.model;

import com.example.demo.infrastructure.helpers.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Person {
    private String idCard;
    private String name;
    private Role role;
    private List<Material> borrowedMaterials;
}
