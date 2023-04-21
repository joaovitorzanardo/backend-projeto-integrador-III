package com.projeto.system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "client")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @Column(name = "client_id")
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long clientId;

    @Column(name = "first_name", nullable = false, length = 200)
    private String first_name;
    @Column(name = "last_name", nullable = false, length = 200)
    private String last_name;
    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(name = "phone_number", nullable = false, unique = true, length = 11)
    private String phone_number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Product> products;

}
