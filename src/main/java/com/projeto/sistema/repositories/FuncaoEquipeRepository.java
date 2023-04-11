package com.projeto.sistema.repositories;

import com.projeto.sistema.entities.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncaoEquipeRepository extends JpaRepository<Funcao, Long> {
}
