package com.projeto.sistema.dto;

import com.projeto.sistema.entities.Equipe;
import com.projeto.sistema.entities.Usuario;
import lombok.Data;

@Data
public class UsuarioEquipeDto {
    private Usuario usuario;
    private Equipe equipe;
}
