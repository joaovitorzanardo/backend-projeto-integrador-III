package com.projeto.sistema.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FuncaoEquipeDto {
    @NotBlank(message = "A descrição da função deve ser informada.")
    private String descricao;
}
