package com.codeventsl.wildLifeManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnimalDTO implements Serializable {
    private String name;
    private String[] location;
}
