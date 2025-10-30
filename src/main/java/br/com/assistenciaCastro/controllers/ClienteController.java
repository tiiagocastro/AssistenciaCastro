package br.com.assistenciaCastro.controllers;

import br.com.assistenciaCastro.dtos.ClienteDTO;
import br.com.assistenciaCastro.dtos.VideoGameDTO;
import br.com.assistenciaCastro.models.Cliente;
import br.com.assistenciaCastro.models.VideoGame;
import br.com.assistenciaCastro.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    // @GetMapping("/{id}") = //Método para buscar cliente por id
    // @GetMapping = Método para listar todos os clientes
    // @PostMapping = Método para criar um novo cliente
    // @PutMapping("/{id}") = Método para atualizar um cliente existente
    // @DeleteMapping("/{id}") = Método para deletar uma cliente pelo ID

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(cliente, ClienteDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> list = clienteService.findAll();
        List<ClienteDTO> listDto = new ArrayList<>();
        for (Cliente cliente : list) {
            listDto.add(modelMapper.map(cliente, ClienteDTO.class));
        }
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping ("/{id}/videogames")
    public ResponseEntity<List<VideoGameDTO>> findVideoGameByCliente(@PathVariable Integer id){
        List<VideoGame> videoGames = clienteService.findVideoGameByCliente(id);
        List<VideoGameDTO> dtoList = new ArrayList<>();
        for (VideoGame vg : videoGames){
            VideoGameDTO videoGameDTO = modelMapper.map(vg, VideoGameDTO.class);
            dtoList.add(videoGameDTO);
        }
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente novoCliente = clienteService.save(cliente);
        return ResponseEntity.ok().body(modelMapper.map(novoCliente, ClienteDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        cliente.setId(id);
        Cliente novoCliente = clienteService.update(cliente, id);
        return ResponseEntity.ok().body(modelMapper.map(novoCliente, ClienteDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
