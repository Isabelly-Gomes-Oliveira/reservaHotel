package com.example.reservaHotel;

import com.example.reservaHotel.repository.HotelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HotelRepositoryTest {

    @Autowired
    private HotelRepository hotelRepository;

    // Inserir hotel no bd
    @Test
    public void inserirHotel() {
        Hotel hotel1 = new Hotel();
        hotel1.setNome("Vitoria");
        hotel1.setEndereco("Avenida Principal, 124 - Campinas-SP");
        hotel1.setTelefone("(19) 3333-1111");
        hotel1.setSite("www.hotelVitoria.com.br");
        hotelRepository.save(hotel1);

        Hotel hotel2 = new Hotel();
        hotel2.setNome("Marcia's Hotel");
        hotel2.setEndereco("Rua da Felicidade, 400 - Campinas-SP");
        hotel2.setTelefone("(19) 3333-2222");
        hotel2.setSite("www.marciasHotel.com.br");
        hotelRepository.save(hotel2);

        System.out.println("Hotéis salvos: '" + hotel1 + "' e '" + hotel2+"'");
    }
}