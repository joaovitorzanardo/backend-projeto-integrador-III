package com.projeto.system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "task_item")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskItem {

    @Id
    @Column(name = "task_item_id")
    @SequenceGenerator(
            name = "task_item_sequence",
            sequenceName = "task_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_item_sequence"
    )
    private Long taskItemId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "task_type_id", nullable = false)
    private TaskType taskType;

    @Column(name = "description")
    private String description;

    @Column(name = "task_status", nullable = false)
    private Integer taskStatus;

    @Column(name = "price")
    private Double price;


}
