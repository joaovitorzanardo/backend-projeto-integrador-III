package com.projeto.sistema.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "equipe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Equipe {

    @Id
    @Column(name = "equipe_id")
    @SequenceGenerator(
            name = "equipe_sequence",
            sequenceName = "equipe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "equipe_sequence"
    )
    private Long equipeId;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "descricao", length = 200)
    private String descricao;

}
