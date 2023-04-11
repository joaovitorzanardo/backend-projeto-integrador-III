package com.projeto.sistema.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Funcao {

    @Id
    @Column(name = "funcao_id")
    @SequenceGenerator(
            name = "funcao_sequence",
            sequenceName = "funcao_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "funcao_sequence"
    )
    private Long funcaoEquipeId;

    @Column(name = "descricao", nullable = false, length = 200)
    private String descricao;

    public Funcao(String descricao) {
        this.descricao = descricao;
    }

}
