package com.projeto.system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "address")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @Column(name = "address_id")
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long addressId;

    @Column(name = "uf", nullable = false, length = 2)
    private String uf;
    @Column(name = "city", nullable = false, length = 200)
    private String city;
    @Column(name = "cep", nullable = false, length = 8)
    private String cep;
    @Column(name = "street", nullable = false, length = 200)
    private String street;
    @Column(name = "district", nullable = false, length = 200)
    private String district;
    @Column(name = "number", nullable = false)
    private int number;
    @Column(name = "reference", length = 200)
    private String reference;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private List<Client> clients;

}
