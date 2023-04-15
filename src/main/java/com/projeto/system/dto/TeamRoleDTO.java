package com.projeto.system.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TeamRoleDTO {
    @NotBlank(message = "A descrição da função deve ser informada.")
    private String description;
}
