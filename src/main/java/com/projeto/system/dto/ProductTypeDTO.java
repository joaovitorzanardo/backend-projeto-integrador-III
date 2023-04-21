package com.projeto.system.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductTypeDTO {
    @NotBlank(message = "A descrição deve ser informada.")
    private String description;
}
