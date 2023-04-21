package com.projeto.system.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientDTO {

    @NotBlank(message = "O primeiro nome deve ser informado.")
    private String firstName;
    @NotBlank(message = "O último nome deve ser informado.")
    private String lastName;
    @NotBlank(message = "O CPF deve ser informado.")
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 dígitos.")
    private String cpf;
    @NotBlank(message = "O número de telefone deve ser informado.")
    @Size(min = 11, max = 11, message = "O número de telefone deve conter 11 dígitos.")
    private String phoneNumber;
    //@NotBlank(message = "O endereço deve ser informado.")
    @JsonProperty("address")
    private AddressDTO addressDTO;

}
