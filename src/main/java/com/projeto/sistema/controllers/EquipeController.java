package com.projeto.sistema.controllers;

import com.projeto.sistema.dto.EquipeDto;
import com.projeto.sistema.entities.Equipe;
import com.projeto.sistema.services.equipe.EquipeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "equipe")
public class EquipeController {

    @Autowired
    private EquipeServiceImpl equipeService;

    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeService.getAllEquipes();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> salvarEquipe(@Valid @RequestBody EquipeDto equipeDto) {
        Equipe novaEquipe = equipeService.salvarEquipe(equipeDto);
        return new ResponseEntity<>(novaEquipe, HttpStatus.CREATED);
    }

}
