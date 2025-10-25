package br.com.assistenciaCastro.dtos;


import java.util.ArrayList;
import java.util.List;

public class ClienteDTO {

    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private List<VideoGameDTO> videoGameDTOList = new ArrayList<>();

    public ClienteDTO() {

    }

    public ClienteDTO(Integer id, String nome, String telefone, String email, List<VideoGameDTO> videoGameDTOList) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.videoGameDTOList = videoGameDTOList;
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
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<VideoGameDTO> getVideoGameDTOList() {
        return videoGameDTOList;
    }

    public void setVideoGameDTOList(List<VideoGameDTO> videoGameDTOList) {
        this.videoGameDTOList = videoGameDTOList;
    }
}
