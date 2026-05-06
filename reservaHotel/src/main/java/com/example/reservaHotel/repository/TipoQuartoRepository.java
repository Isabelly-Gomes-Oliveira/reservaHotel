package com.example.reservaHotel.repository;

import com.example.reservaHotel.TipoQuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoQuartoRepository extends JpaRepository<TipoQuarto, Integer> {

    // Busca tipo de quarto pela descrição
    TipoQuarto findByDescricao(String descricao);
}