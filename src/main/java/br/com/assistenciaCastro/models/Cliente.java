package br.com.assistenciaCastro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    @Column(unique = true)
    private String telefone;

    @Column(unique = true)
    private String email;

    public Cliente() {
    }

    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        setTelefone(telefone);
        this.email = email;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<VideoGame> videoGames = new ArrayList<>();

    public List<VideoGame> getVideoGames() {
        return videoGames;
    }

    public void setVideoGames(List<VideoGame> videoGames) {
        this.videoGames = videoGames;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.replaceAll("\\D", "");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", videoGames=" + videoGames +
                '}';
    }
}
