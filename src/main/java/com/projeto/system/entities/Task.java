package com.projeto.system.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "task")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task {

    @Id
    @Column(name = "task_id")
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long taskId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "deadline")
    private Date deadline;

    @ManyToOne
    private TeamMember teamMember;

    @ManyToOne
    @JoinColumn(name = "task_status_id")
    private TaskStatus taskStatus;

    @Column(name = "total_price")
    private double totalPrice;

}
