package com.projeto.system.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskItemDTO {
    @NotNull(message = "O producto deve ser informado.")
    private Long productId;
    @NotNull(message = "O tipo da tarefa deve ser informado.")
    private Long taskTypeId;
    @NotEmpty(message = "A descrição não pode ser uma string vazia.")
    private String description;
    private Integer taskStatus;
    private Double Price;
}
