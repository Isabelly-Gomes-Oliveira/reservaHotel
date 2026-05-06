package com.example.reservaHotel;

import java.util.Date;
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

    @Column(name="qtdeDias")
    private Integer qtdeDias;

    @Column(name="valorTotal")
    private Double valorTotal;

    @Column(name="status")
    private String status;

    // FK's:
    @ManyToOne // N reservas para 1 Quarto
    @JoinColumn(name = "quarto_id") 
    private Quarto quarto;

    @ManyToOne // N reservas para 1 Hóspede
    @JoinColumn(name = "hospede_id")
    private Hospede hospede;
}