package com.projeto.system.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "team_role")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamRole {

    @Id
    @Column(name = "team_role_id")
    @SequenceGenerator(
            name = "team_role_sequence",
            sequenceName = "team_role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "team_role_sequence"
    )
    private Long teamRoleId;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    public TeamRole(String description) {
        this.description = description;
    }

}
