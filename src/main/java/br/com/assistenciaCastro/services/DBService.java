package br.com.assistenciaCastro.services;

import br.com.assistenciaCastro.enums.StatusConserto;
import br.com.assistenciaCastro.models.Cliente;
import br.com.assistenciaCastro.models.VideoGame;
import br.com.assistenciaCastro.repositories.ClienteRepository;
import br.com.assistenciaCastro.repositories.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VideoGameRepository videoGameRepository;

    public void instanciaDB() {
        Cliente c1 = new Cliente("Tiago Castro", "81987870003", "tiiagocastro.tc@gmail.com");
        Cliente c2 = new Cliente("Ana Luiza", "81984540002", "analuizabeloas@gmail.com");
        Cliente c3 = new Cliente("Rosa de Castro", "81987870002", "rosinhalindinha123@gmail.com");

        VideoGame vg1 = new VideoGame("Sony", "Ps5", "O console não tem defeito, mas está empoeirado e eu gostaria de uma manutenção!",
                c1, StatusConserto.RECEBIDO);
        VideoGame vg3 = new VideoGame("Microsoft", "Xbox 360", "Deu luz vermelha no botão de ligar!",
                c1, StatusConserto.EM_CONSERTO);
        VideoGame vg5 = new VideoGame("Sony", "Ps3", "O analógico deu drift. Preciso trocar!",
                c1, StatusConserto.CONCLUIDO);


        VideoGame vg2 = new VideoGame("Nintendo", "Switch", "O analógico deu drift. Preciso trocar!",
                c2, StatusConserto.RECEBIDO);
        VideoGame vg4 = new VideoGame("Microsoft", "Xbox One", "O analógico deu drift. Preciso trocar!",
                c2, StatusConserto.RECEBIDO);

        c1.getVideoGames().addAll(Arrays.asList(vg1, vg3, vg5));
        c2.getVideoGames().addAll(Arrays.asList(vg2, vg4));

        clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
        videoGameRepository.saveAll(Arrays.asList(vg1,vg2,vg3,vg4,vg5));
    }
}
