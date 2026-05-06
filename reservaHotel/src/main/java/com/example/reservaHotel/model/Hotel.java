package com.example.reservaHotel;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name="hotel")
@Data
public class Hotel {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome", length= 40)
    private String nome;

    @Column(name="endereco", length= 100)
    private String endereco;

    @Column(name="telefone", length= 14)
    private String telefone;

    @Column(name="site", length= 50)
    private String site;

    // FK's:
    @OneToMany(mappedBy = "hotel") // 1 hotel para N quartos
    private List<Quarto> quartos;
}