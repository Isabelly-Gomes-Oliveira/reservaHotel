package com.example.reservaHotel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="hospede")
@Data
public class Hospede {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="cpf", leght= 11)
    private String cpf;

    @Column(name="nomeCompleto", lenght= 80)
    private String nomeCompleto;

    @Column(name="dataNascimento")
    private Date dataNascimento;

    @Column(name="email", lenght= 80)
    private String email;

    @Column(name="celular", lenght= 14)
    private String celular;

    // FK's:
    // - possui Reserva
}