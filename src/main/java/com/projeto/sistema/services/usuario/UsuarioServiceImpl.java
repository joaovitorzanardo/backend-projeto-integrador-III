package com.projeto.sistema.services.usuario;

import com.projeto.sistema.dto.UsuarioDto;
import com.projeto.sistema.entities.Usuario;
import com.projeto.sistema.constants.TipoUsuario;
import com.projeto.sistema.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> getUsuarios() {
        return  usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setPrimeiroNome(usuarioDto.getPrimeiroNome());
        usuario.setUltimoNome(usuarioDto.getUltimoNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuarioDto.getSenha()));
        usuario.setOrganizacao(usuarioDto.getOrganizacao());
        usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
        return usuarioRepository.save(usuario);
    }


}
