package com.example.reservaHotel;

import com.example.reservaHotel.repository.HospedeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class HospedeRepositoryTest {

    @Autowired
    private HospedeRepository hospedeRepository;

    // Inserir hóspede no bd
    @Test
    public void inserirHospede() {
        Hospede hospede1 = new Hospede();
        hospede1.setCpf("12345678967");
        hospede1.setNomeCompleto("João Gomes dos Santos");
        hospede1.setDataNascimento(new Date());
        hospede1.setEmail("joaogomes@email.com");
        hospede1.setCelular("(19) 99999-9999");

        hospedeRepository.save(hospede1);

        Hospede hospede2 = new Hospede();
        hospede2.setCpf("33369000927");
        hospede2.setNomeCompleto("Maria Cristina de Jesus");
        hospede2.setDataNascimento(new Date());
        hospede2.setEmail("mariadejesus@email.com");
        hospede2.setCelular("(10) 49949-8829");

        hospedeRepository.save(hospede2);

        System.out.println("Hóspedes salvos: " + hospede1 + " | " + hospede2);
    }

    // Listar nome e email dos hóspedes com a reserva ATIVA
    @Test
    public void listarHospedesComReservaAtiva() {
        List<Object[]> resultado = hospedeRepository.hospedesComReservaAtiva();

        System.out.println("Hóspedes com Reserva ATIVA");
        for (Object[] linha : resultado) {
            System.out.println("Nome: " + linha[0] + " | Email: " + linha[1]);
        }
    }
}