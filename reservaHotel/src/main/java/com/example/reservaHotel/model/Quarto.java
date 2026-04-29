package com.example.reservaHotel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="quarto")
@Data
public class Quarto {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="numero")
    private Integer numero;

    @Column(name="capacidade")
    private Integer capacidade;

    @Column(name="status")
    private String status;

    @Column(name="valorDiaria")
    private Double valorDiaria;

    // FK's:
    // - tem TipoQuarto
    // - pertence a Hotel
    // - tem Reserva

}