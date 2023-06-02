package com.projeto.system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank(message = "O primeiro nome deve ser informado.")
    private String firstName;
    @NotBlank(message = "O último nome deve ser informado.")
    private String lastName;
    @NotBlank(message = "O email deve ser informado.")
    @Email(message = "Formato de email inválido.")
    private String email;
    @NotBlank(message = "A senha deve ser informada.")
    @Size(min = 8, max = 72, message = "A senha deve ter no mínimo 8 e no máximo 72 caracteres.")
    private String password;
    @NotBlank(message = "O nome da organização deve ser informado.")
    private String organization;
    private Long teamId;
}
