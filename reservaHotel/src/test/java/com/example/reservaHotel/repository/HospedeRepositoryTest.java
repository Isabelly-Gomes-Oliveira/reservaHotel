package com.example.reservaHotel;

import com.example.reservaHotel.repository.HospedeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class HospedeTest {

    @Autowired
    private HospedeRepository hospedeRepository;

    // Inserir hóspede no banco
    @Test
    public void inserirHospede() {
        Hospede hospede = new Hospede();
        hospede.setCpf("12345678967");
        hospede.setNomeCompleto("João Gomes");
        hospede.setDataNascimento(new Date());
        hospede.setEmail("joao@email.com");
        hospede.setCelular("(19) 99999-9999");

        hospedeRepository.save(hospede);
        System.out.println("Hóspede salvo: " + hospede);
    }

    // Listar nome e email dos hóspedes com reserva ATIVA
    @Test
    public void listarHospedesComReservaAtiva() {
        List<Object[]> resultado = hospedeRepository.findHospedesComReservaAtiva();

        System.out.println("Hóspedes com Reserva ATIVA");
        for (Object[] linha : resultado) {
            System.out.println("Nome: " + linha[0] + " | Email: " + linha[1]);
        }
    }
}