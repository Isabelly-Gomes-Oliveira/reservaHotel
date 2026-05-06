package com.example.reservaHotel.repository;

import com.example.reservaHotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    // Busca hotel pelo nome (usado no teste de quartos VIP do hotel VITORIA)
    Hotel findByNome(String nome);
}