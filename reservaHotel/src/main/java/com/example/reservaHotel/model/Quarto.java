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
    @ManyToOne // N quartos para 1 TipoQuarto
    @JoinColumn(name = "tipoquarto_id") 
    private TipoQuarto tipoQuarto;

    @ManyToOne // N quartos para 1 Hotel
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}