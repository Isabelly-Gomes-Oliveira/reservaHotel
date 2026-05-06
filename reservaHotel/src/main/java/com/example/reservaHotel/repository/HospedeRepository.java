package com.example.reservaHotel.repository;

import com.example.reservaHotel.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Integer> {

    // Lista nome e email dos hóspedes com reserva ATIVA
    @Query("SELECT h.nomeCompleto, h.email FROM Hospede h " +
           "JOIN h.reservas r " +
           "WHERE r.status = 'ativa'")
    List<Object[]> hospedesComReservaAtiva();
}