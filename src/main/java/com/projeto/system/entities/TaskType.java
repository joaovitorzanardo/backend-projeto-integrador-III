package com.projeto.system.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "task_type")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskType {

    @Id
    @Column(name = "task_type_id")
    @SequenceGenerator(
            name = "task_type_sequence",
            sequenceName = "task_type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_type_sequence"
    )
    private Long taskTypeId;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

}
