package com.projeto.system.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class TaskDTO {

    @NotNull(message = "O cliente deve ser informado.")
    private Long clientId;
    private String deadline;
    private Long teamMemberId;
    @NotNull(message = "O tipo de tarefa deve ser informado.")
    private Long taskTypeId;
    @JsonProperty("taskItems")
    List<TaskItemDTO> taskItems;

}
