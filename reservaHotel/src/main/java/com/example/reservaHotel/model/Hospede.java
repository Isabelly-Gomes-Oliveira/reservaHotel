package com.example.reservaHotel;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="hospede")
@Data
public class Hospede {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="cpf", length= 11)
    private String cpf;

    @Column(name="nomeCompleto", length= 80)
    private String nomeCompleto;

    @Column(name="dataNascimento")
    private Date dataNascimento;

    @Column(name="email", length= 80)
    private String email;

    @Column(name="celular", length= 14)
    private String celular;

    // FK's:
    @OneToMany(mappedBy = "hospede") // 1 hóspede para N reservas
    private List<Reserva> reservas;
}