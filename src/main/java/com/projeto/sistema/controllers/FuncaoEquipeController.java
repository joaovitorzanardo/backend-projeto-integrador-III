package com.projeto.sistema.controllers;

import com.projeto.sistema.dto.FuncaoEquipeDto;
import com.projeto.sistema.entities.Funcao;
import com.projeto.sistema.services.funcaoEquipe.FuncaoEquipeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "funcao-equipe")
public class FuncaoEquipeController {

    @Autowired
    private FuncaoEquipeServiceImpl funcaoEquipeService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Funcao> salvarFuncaoEquipe(@Valid @RequestBody FuncaoEquipeDto funcaoEquipeDto) {
        Funcao funcaoEquipe = funcaoEquipeService.salvarFuncaoEquipe(funcaoEquipeDto);
        return new ResponseEntity<Funcao>(funcaoEquipe, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Funcao> getAllFuncaoEquipe() {
        return funcaoEquipeService.getAllFuncaoEquipe();
    }

}
