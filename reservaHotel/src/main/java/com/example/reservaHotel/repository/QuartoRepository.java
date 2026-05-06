package com.example.reservaHotel.repository;

import com.example.reservaHotel.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {

    // Lista os dados dos quartos do tipo VIP do hotel VITORIA
    @Query("SELECT q FROM Quarto q " +
           "JOIN q.tipoQuarto tq " +
           "JOIN q.hotel h " +
           "WHERE tq.descricao = :tipoQuarto " +
           "AND h.nome = :nomeHotel")
    List<Quarto> findByTipoQuartoAndHotel(@Param("tipoQuarto") String tipoQuarto, @Param("nomeHotel") String nomeHotel);
}