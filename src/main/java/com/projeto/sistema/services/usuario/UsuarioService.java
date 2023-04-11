package com.projeto.sistema.services.usuario;

import com.projeto.sistema.dto.UsuarioDto;
import com.projeto.sistema.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> getUsuarios();
    public Usuario salvarUsuario(UsuarioDto usuarioDto);

}
