package com.projeto.sistema.services.equipe;

import com.projeto.sistema.dto.EquipeDto;
import com.projeto.sistema.entities.Equipe;

import java.util.List;

public interface EquipeService {

    public List<Equipe> getAllEquipes();

    public Equipe salvarEquipe(EquipeDto equipeDto);

}
