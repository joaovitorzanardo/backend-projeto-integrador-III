package com.projeto.system.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class TeamDTO {
    @NotBlank(message = "O nome da equipe deve ser informado.")
    private String name;
    private String description;
}
