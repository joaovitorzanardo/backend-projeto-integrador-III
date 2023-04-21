package com.projeto.system.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskTypeDTO {
    @NotBlank(message = "A descrição deve ser informada.")
    private String description;
}
