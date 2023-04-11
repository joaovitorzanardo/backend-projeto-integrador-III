package com.projeto.sistema.services.funcaoEquipe;

import com.projeto.sistema.dto.FuncaoEquipeDto;
import com.projeto.sistema.entities.Funcao;

import java.util.List;

public interface FuncaoEquipeService {

    public Funcao salvarFuncaoEquipe(FuncaoEquipeDto funcaoEquipeDto);
    public List<Funcao> getAllFuncaoEquipe();

}
