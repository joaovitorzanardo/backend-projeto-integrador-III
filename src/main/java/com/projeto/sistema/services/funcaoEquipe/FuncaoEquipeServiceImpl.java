package com.projeto.sistema.services.funcaoEquipe;

import com.projeto.sistema.dto.FuncaoEquipeDto;
import com.projeto.sistema.entities.Funcao;
import com.projeto.sistema.repositories.FuncaoEquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncaoEquipeServiceImpl implements FuncaoEquipeService {

    @Autowired
    private FuncaoEquipeRepository funcaoEquipeRepository;

    @Override
    public Funcao salvarFuncaoEquipe(FuncaoEquipeDto funcaoEquipeDto) {
        return funcaoEquipeRepository.save(new Funcao(funcaoEquipeDto.getDescricao()));
    }

    @Override
    public List<Funcao> getAllFuncaoEquipe() {
        return funcaoEquipeRepository.findAll();
    }
}
