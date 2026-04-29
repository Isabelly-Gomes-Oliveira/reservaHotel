package com.example.reservaHotel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="hotel")
@Data
public class Hotel {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome", lenght= 40)
    private String nome;

    @Column(name="endereco", leght= 100)
    private String endereco;

    @Column(name="telefone", leght= 14)
    private String telefone;

    @Column(name="site", leght= 50)
    private String site;

    // FK's:
    // - possui Quarto
}