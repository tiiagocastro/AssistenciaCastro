package br.com.assistenciaCastro.dtos;

import br.com.assistenciaCastro.enums.StatusConserto;

public class VideoGameDTO {

    private Integer id;
    private String nomeCliente;
    private String marca;
    private String modelo;
    private String defeito;
    private StatusConserto status;

    public VideoGameDTO() {
    }

    public VideoGameDTO(Integer id, String nomeCliente, String marca, String modelo, String defeito, StatusConserto status) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.marca = marca;
        this.modelo = modelo;
        this.defeito = defeito;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public StatusConserto getStatus() {
        return status;
    }

    public void setStatus(StatusConserto status) {
        this.status = status;
    }
}
