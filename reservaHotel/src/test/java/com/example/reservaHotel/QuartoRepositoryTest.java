package com.example.reservaHotel;

import com.example.reservaHotel.repository.HotelRepository;
import com.example.reservaHotel.repository.QuartoRepository;
import com.example.reservaHotel.repository.TipoQuartoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QuartoRepositoryTest {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private TipoQuartoRepository tipoQuartoRepository;

    // Inserir quartos no bd
    @Test
    public void inserirQuarto() {

        //  procurando hotel e tipos já inseridos anteriormente
        Hotel hotelVitoria   = hotelRepository.findByNome("Vitoria");
        Hotel hotelMarcias = hotelRepository.findByNome("Marcia's Hotel");

        TipoQuarto tipoComum = tipoQuartoRepository.findByDescricao("comum");
        TipoQuarto tipoVip = tipoQuartoRepository.findByDescricao("vip");
        TipoQuarto tipoEmpresarial = tipoQuartoRepository.findByDescricao("empresarial");

        // quartos do hotel "Vitoria"
        Quarto q1 = new Quarto();
        q1.setNumero(101);
        q1.setCapacidade(2);
        q1.setStatus("disponivel");
        q1.setValorDiaria(150.00);
        q1.setTipoQuarto(tipoComum);
        q1.setHotel(hotelVitoria);
        quartoRepository.save(q1);

        Quarto q2 = new Quarto();
        q2.setNumero(102);
        q2.setCapacidade(3);
        q2.setStatus("disponivel");
        q2.setValorDiaria(350.00);
        q2.setTipoQuarto(tipoVip);
        q2.setHotel(hotelVitoria);
        quartoRepository.save(q2);

        Quarto q3 = new Quarto();
        q3.setNumero(103);
        q3.setCapacidade(2);
        q3.setStatus("disponivel");
        q3.setValorDiaria(280.00);
        q3.setTipoQuarto(tipoEmpresarial);
        q3.setHotel(hotelVitoria);
        quartoRepository.save(q3);

        // Quartos do hotel "Marcia's Hotel"
        Quarto q4 = new Quarto();
        q4.setNumero(201);
        q4.setCapacidade(2);
        q4.setStatus("disponivel");
        q4.setValorDiaria(120.00);
        q4.setTipoQuarto(tipoComum);
        q4.setHotel(hotelMarcias);
        quartoRepository.save(q4);

        Quarto q5 = new Quarto();
        q5.setNumero(202);
        q5.setCapacidade(4);
        q5.setStatus("disponivel");
        q5.setValorDiaria(400.00);
        q5.setTipoQuarto(tipoVip);
        q5.setHotel(hotelMarcias);
        quartoRepository.save(q5);

        System.out.println("Quartos salvos com sucesso!");
    }

    // Listar dados dos quartos vip do hotel "Vitoria"
    @Test
    public void listarQuartosVipHotelVitoria() {
        List<Quarto> quartos = quartoRepository.findByTipoQuartoAndHotel("vip", "Vitoria");

        System.out.println("Quartos VIP do hotel Vitoria ");
        for (Quarto q : quartos) {
            System.out.println("Número: "    + q.getNumero()
                    + " | Capacidade: " + q.getCapacidade()
                    + " | Status: "     + q.getStatus()
                    + " | Diária: R$"  + q.getValorDiaria());
        }
    }
}