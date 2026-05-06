package com.example.reservaHotel;

import com.example.reservaHotel.repository.TipoQuartoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TipoQuartoRepositoryTest {

    @Autowired
    private TipoQuartoRepository tipoQuartoRepository;

    // Inserir tipos de quarto no bd
    @Test
    public void inserirTiposDeQuarto() {

        TipoQuarto comum = new TipoQuarto();
        comum.setDescricao("comum");
        tipoQuartoRepository.save(comum);

        TipoQuarto vip = new TipoQuarto();
        vip.setDescricao("vip");
        tipoQuartoRepository.save(vip);

        TipoQuarto empresarial = new TipoQuarto();
        empresarial.setDescricao("empresarial");
        tipoQuartoRepository.save(empresarial);

        System.out.println("Tipos de quarto salvos: comum, vip, empresarial");
    }
}