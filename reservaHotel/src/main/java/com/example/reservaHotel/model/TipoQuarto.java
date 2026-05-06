package com.example.reservaHotel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tipoQuarto")
@Data
public class TipoQuarto {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="descricao")
    private String descricao;

    // FK's:
    @OneToMany(mappedBy = "tipoQuarto") // 1 tipo para N quartos
    private List<Quarto> quartos;
}