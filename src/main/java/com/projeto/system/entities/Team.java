package com.projeto.system.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "team")
@Builder
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

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<User> users;

}
