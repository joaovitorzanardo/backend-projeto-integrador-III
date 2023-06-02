package com.projeto.system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskDTO {

    @NotNull(message = "O cliente deve ser informado.")
    private Long clientId;
    private String deadline;
    @NotNull(message = "O tipo de tarefa deve ser informado.")
    private Long taskTypeId;
    @NotNull(message = "O produto da tarefa deve ser informado.")
    private Long productId;
    @NotNull(message = "O status da tarefa deve ser informado.")
    private Integer status;
    @NotNull(message = "A descrição da tarefa deve ser informado.")
    private String description;
    private Double price;
    //private Long userId;
}
