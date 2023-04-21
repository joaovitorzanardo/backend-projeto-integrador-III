package com.projeto.system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {

    @NotNull(message = "O id do cliente deve ser informado.")
    private Long clientId;
    private Long productTypeId;

}
