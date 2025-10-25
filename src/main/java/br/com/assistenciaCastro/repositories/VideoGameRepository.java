package br.com.assistenciaCastro.repositories;

import br.com.assistenciaCastro.models.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Integer> {

}
