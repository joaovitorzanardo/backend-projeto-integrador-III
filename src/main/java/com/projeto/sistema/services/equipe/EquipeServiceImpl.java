package com.projeto.sistema.services.equipe;

import com.projeto.sistema.dto.EquipeDto;
import com.projeto.sistema.entities.Equipe;
import com.projeto.sistema.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe salvarEquipe(EquipeDto equipeDto) {
        Equipe equipe = new Equipe();
        equipe.setNome(equipeDto.getNome());
        equipe.setDescricao(equipeDto.getDescricao());
        return equipeRepository.save(equipe);
    }
}
