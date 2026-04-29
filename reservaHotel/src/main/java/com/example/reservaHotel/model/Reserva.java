package com.example.reservaHotel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="reserva")
@Data
public class Reserva {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="datacheckin")
    private Date datacheckin;

    @Column(name="datacheckout")
    private Date datacheckout;

    @Column(name="qtdeDias", )
    private Integer qtdeDias;

    @Column(name="valorTotal")
    private Double valorTotal;

    @Column(name="status")
    private String status;

    // FK's:
    // - pertence a Hospede
    // - pertence a Quarto
}