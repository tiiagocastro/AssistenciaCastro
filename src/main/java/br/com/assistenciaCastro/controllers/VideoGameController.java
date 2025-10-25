package br.com.assistenciaCastro.controllers;

import br.com.assistenciaCastro.dtos.VideoGameDTO;
import br.com.assistenciaCastro.models.VideoGame;
import br.com.assistenciaCastro.services.VideoGameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/videogames")
public class VideoGameController {
    // @GetMapping("/{id}") = //Método para buscar categoria por id
    // @GetMapping = Método para listar todas as categorias
    // @PostMapping = Método para criar uma nova categoria
    // @PutMapping("/{id}") = Método para atualizar uma categoria existente
    // @DeleteMapping("/{id}") = Método para deletar uma categoria pelo ID

    @Autowired
    private VideoGameService videoGameService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<VideoGameDTO> findById(@PathVariable Integer id) {
        VideoGame videoGame = videoGameService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(videoGame, VideoGameDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<VideoGameDTO>> findAll() {
        List<VideoGame> list = videoGameService.findAll();
        List<VideoGameDTO> listDto = new ArrayList<>();

        for (VideoGame videoGame : list) {
            listDto.add(modelMapper.map(videoGame, VideoGameDTO.class));
        }
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<VideoGameDTO> save(@RequestBody VideoGameDTO videoGameDTO) {
        VideoGame videoGame = modelMapper.map(videoGameDTO, VideoGame.class);
        VideoGame vgame = videoGameService.save(videoGame);
        return ResponseEntity.ok().body(modelMapper.map(vgame, VideoGameDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoGameDTO> update(@PathVariable Integer id, @RequestBody VideoGameDTO videoGameDTO) {
        VideoGame videoGame = modelMapper.map(videoGameDTO, VideoGame.class);
        videoGame.setId(id);
        VideoGame vgame = videoGameService.update(videoGame);
        return ResponseEntity.ok().body(modelMapper.map(vgame, VideoGameDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        videoGameService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
