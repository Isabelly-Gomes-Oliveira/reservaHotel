package com.example.reservaHotel;

import com.example.reservaHotel.repository.HospedeRepository;
import com.example.reservaHotel.repository.QuartoRepository;
import com.example.reservaHotel.repository.ReservaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ReservaRepositoryTest {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    // Inserir reservas no bd
    @Test
    public void inserirReserva() {

        // Busca hóspede e quarto já inseridos
        Hospede hospede1 = hospedeRepository.findById(1).orElseThrow();
        Hospede hospede2 = hospedeRepository.findById(2).orElseThrow();

        Quarto quartoComum = quartoRepository.findById(1).orElseThrow();
        Quarto quartoVip   = quartoRepository.findById(2).orElseThrow();

        // Datas
        Date hoje = new Date();
        Date checkout3dias = adicionarDias(hoje, 3);
        Date checkout5dias = adicionarDias(hoje, 5);

        // Somar dias para uma data
        private Date adicionarDias(Date data, int dias) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(data);
            cal.add(Calendar.DAY_OF_MONTH, dias);
            return cal.getTime();
        }

        // Reserva ATIVA — hóspede 1 no quarto comum
        Reserva r1 = new Reserva();
        r1.setDatacheckin(hoje);
        r1.setDatacheckout(checkout3dias);
        r1.setQtdeDias(3);
        r1.setValorTotal(quartoComum.getValorDiaria() * 3);
        r1.setStatus("ativa");
        r1.setQuarto(quartoComum);
        r1.setHospede(hospede1);
        reservaRepository.save(r1);

        // Reserva ATIVA — hóspede 2 no quarto VIP
        Reserva r2 = new Reserva();
        r2.setDatacheckin(hoje);
        r2.setDatacheckout(checkout5dias);
        r2.setQtdeDias(5);
        r2.setValorTotal(quartoVip.getValorDiaria() * 5);
        r2.setStatus("ativa");
        r2.setQuarto(quartoVip);
        r2.setHospede(hospede2);
        reservaRepository.save(r2);

        // Reserva CANCELADA — hóspede 1 no quarto VIP
        Reserva r3 = new Reserva();
        r3.setDatacheckin(hoje);
        r3.setDatacheckout(checkout3dias);
        r3.setQtdeDias(3);
        r3.setValorTotal(quartoVip.getValorDiaria() * 3);
        r3.setStatus("cancelada");
        r3.setQuarto(quartoVip);
        r3.setHospede(hospede1);
        reservaRepository.save(r3);

        System.out.println("Reservas salvas com sucesso!");
    }

    // Listar nome e email dos hóspedes com reserva ATIVA
    @Test
    public void listarHospedesComReservaAtiva() {
        List<Object[]> resultado = reservaRepository.findHospedesComReservaAtiva();

        System.out.println("Hóspedes com Reserva ATIVA");
        for (Object[] linha : resultado) {
            System.out.println("Nome: " + linha[0] + " | Email: " + linha[1]);
        }
    }
}