package br.com.assistenciaCastro.services;

import br.com.assistenciaCastro.exceptions.ObjectNotFoundExceptions;
import br.com.assistenciaCastro.models.VideoGame;
import br.com.assistenciaCastro.repositories.VideoGameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService {

    @Autowired
    private VideoGameRepository videoGameRepository;

    public VideoGame findById(Integer id) {
        Optional<VideoGame> videoGame = videoGameRepository.findById(id);
        if (videoGame.isPresent()) {
            return videoGame.get();
        }
        throw new ObjectNotFoundExceptions("Video game não encontrado com o id" + id);
    }

    public List<VideoGame> findAll() {
        return videoGameRepository.findAll();
    }

    public VideoGame save(VideoGame videoGame) {
        return videoGameRepository.save(videoGame);
    }

    public VideoGame update(VideoGame videoGame) {
        VideoGame vGame = findById(videoGame.getId());

        vGame.setMarca(videoGame.getMarca());
        vGame.setModelo(videoGame.getModelo());
        vGame.setDefeito(videoGame.getDefeito());
        vGame.setStatus(videoGame.getStatus());

        videoGameRepository.save(vGame);
        return vGame;
    }

    public void delete(Integer id) {
        VideoGame vGame = findById(id);
        videoGameRepository.delete(vGame);
    }
}
