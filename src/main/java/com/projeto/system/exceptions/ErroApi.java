package com.projeto.system.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class ErroApi {
    private HttpStatus status;
    private String mensagem;
    private List<Erro> erros;
}
