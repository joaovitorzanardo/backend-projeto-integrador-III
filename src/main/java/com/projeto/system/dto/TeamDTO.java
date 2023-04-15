package com.projeto.system.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TeamDTO {
    @NotBlank(message = "O nome da equipe deve ser informado.")
    private String name;
    private String description;
}
