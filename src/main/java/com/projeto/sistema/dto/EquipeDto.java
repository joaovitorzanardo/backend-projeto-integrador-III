package com.projeto.sistema.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EquipeDto {
    @NotBlank(message = "O nome da equipe deve ser informado.")
    private String nome;
    private String descricao;
}
