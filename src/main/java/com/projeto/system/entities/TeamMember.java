package com.projeto.system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "team_member")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamMember {

    @Id
    @Column(name = "team_member_id")
    @SequenceGenerator(
            name = "team_member_sequence",
            sequenceName = "team_member_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "team_member_sequence"
    )
    @JsonIgnore
    private Long teamMemberId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;

}
