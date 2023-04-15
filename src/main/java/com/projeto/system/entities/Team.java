package com.projeto.system.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "team")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Team {

    @Id
    @Column(name = "team_id")
    @SequenceGenerator(
            name = "team_sequence",
            sequenceName = "team_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "team_sequence"
    )
    private Long teamId;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "description", length = 200)
    private String description;

}
