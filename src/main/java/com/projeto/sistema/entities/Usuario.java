package com.projeto.sistema.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @Column(name = "usuario_id")
    @SequenceGenerator(
            name = "usuario_sequence",
            sequenceName = "usuario_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usuario_sequence"
    )
    private Long usuarioId;

    @Column(name = "primeiro_nome", nullable = false, length = 200)
    private String primeiroNome;

    @Column(name = "ultimo_nome", nullable = false, length = 200)
    private String ultimoNome;

    @Column(name = "email", unique = true, nullable = false, length = 200)
    private String email;

    @Column(name = "senha", nullable = false, length = 60)
    private String senha;

    @Column(name = "organizacao", nullable = false, length = 200)
    private String organizacao;

    @Column(name = "tipo_usuario", nullable = false, length = 50)
    private String tipoUsuario;

}
