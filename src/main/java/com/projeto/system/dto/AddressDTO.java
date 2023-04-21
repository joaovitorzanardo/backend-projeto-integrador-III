package com.projeto.system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressDTO {

    @NotBlank(message = "A uf deve ser informada.")
    private String uf;
    @NotBlank(message = "A cidade deve ser informada.")
    private String city;
    @NotBlank(message = "O CEP deve ser informado.")
    @Size(min = 8, max = 8, message = "O CEP deve conter 8 dígitos")
    private String cep;
    @NotBlank(message = "A rua deve ser informada.")
    private String street;
    @NotBlank(message = "O bairro deve ser informado.")
    private String district;
    @NotBlank(message = "O número ser informado.")
    private int number;
    private String reference;

}
