package com.projeto.sistema.controllers;

import com.projeto.sistema.dto.UsuarioDto;
import com.projeto.sistema.entities.Usuario;
import com.projeto.sistema.services.usuario.UsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "usuario")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    @Autowired
    public UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Usuario> salvarUsuario(@Valid @RequestBody UsuarioDto usuarioDto){
        Usuario novoUsuario = usuarioService.salvarUsuario(usuarioDto);
        return new ResponseEntity<Usuario>(novoUsuario, HttpStatus.CREATED);
    }
}
