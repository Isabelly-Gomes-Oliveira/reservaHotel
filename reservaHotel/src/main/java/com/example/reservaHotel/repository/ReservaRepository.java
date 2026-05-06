package com.example.reservaHotel.repository;

import com.example.reservaHotel.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    // Lista nome e email dos hóspedes com reserva ATIVA
    @Query("SELECT h.nomeCompleto, h.email FROM Reserva r " +
           "JOIN r.hospede h " +
           "WHERE r.status = 'ativa'")
    List<Object[]> findHospedesComReservaAtiva();

    // Lista todas as reservas por status
    List<Reserva> findByStatus(String status);
}