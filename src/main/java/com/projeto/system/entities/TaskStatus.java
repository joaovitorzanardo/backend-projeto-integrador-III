package com.projeto.system.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "task_status")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskStatus {

    @Id
    @Column(name = "task_status_id")
    @SequenceGenerator(
            name = "task_status_sequence",
            sequenceName = "task_status_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_status_sequence"
    )
    private Long taskStatusId;

    @Column(name = "description")
    private String description;

}
