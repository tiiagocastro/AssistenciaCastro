package br.com.assistenciaCastro.services;

import br.com.assistenciaCastro.exceptions.ObjectNotFoundExceptions;
import br.com.assistenciaCastro.models.Cliente;
import br.com.assistenciaCastro.models.VideoGame;
import br.com.assistenciaCastro.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundExceptions("Cliente não encontrado com o id" + id));
    }

    public List<Cliente> findAll() {

        return clienteRepository.findAll();
    }

    public List<VideoGame> findVideoGameByCliente(Integer clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() ->
                new RuntimeException("Cliente não encontrado com esse id. " + clienteId));
        return cliente.getVideoGames();
    }

    public Cliente update(Cliente cliente, Integer id) {
        Cliente clienteExistente = findById(id);
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setTelefone(cliente.getTelefone());
        clienteExistente.setEmail(cliente.getEmail());
        return clienteRepository.save(clienteExistente);
    }

    public void delete(Integer id) {
        Cliente clienteExiste = findById(id);
        clienteRepository.delete(clienteExiste);
    }

    public Cliente save(Cliente cliente) {
        buscarCliente(cliente);
        return clienteRepository.save(cliente);
    }

    public void buscarCliente(Cliente cliente) {
        Optional<Cliente> c = clienteRepository.findByEmailIgnoreCase(cliente.getEmail());
        if (c.isPresent()) {
            if (c.get().getId() != cliente.getId()) {
                throw new IllegalArgumentException("Cliente já existe com o email: " + cliente.getEmail());
            }
        }
    }

}
