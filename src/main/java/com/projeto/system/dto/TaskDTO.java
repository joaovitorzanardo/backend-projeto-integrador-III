package com.projeto.system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class TaskDTO {

    @NotNull
    private Long clientId;
    private Date deadline;
    private Long teamMemberId;
    @NotBlank
    private Long taskTypeId;

}
