package com.projeto.system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "product_type")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductType {

    @Id
    @Column(name = "product_type_id")
    @SequenceGenerator(
            name = "product_type_sequence",
            sequenceName = "product_type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_type_sequence"
    )
    private Long productTypeId;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @OneToMany(mappedBy = "productType")
    @JsonIgnore
    private List<Product> products;

}
