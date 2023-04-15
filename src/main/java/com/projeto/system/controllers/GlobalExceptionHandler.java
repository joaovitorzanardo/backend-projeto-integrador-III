package com.projeto.system.controllers;

import exceptions.Erro;
import exceptions.ErroApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Component
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErroApi> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<Erro> erros = new ArrayList<>();
        ErroApi erroApi = ErroApi.builder()
                .status(HttpStatus.BAD_REQUEST)
                .mensagem("Erro na validação dos dados!")
                .build();
        for (FieldError err : ex.getFieldErrors()) {
            Erro erro = new Erro();
            erro.setClasse(err.getObjectName());
            erro.setAtributo(err.getField());
            erro.setMensagem(err.getDefaultMessage());
            erros.add(erro);
        };
        erroApi.setErros(erros);
        return new ResponseEntity<ErroApi>(erroApi, erroApi.getStatus());
    }

}
