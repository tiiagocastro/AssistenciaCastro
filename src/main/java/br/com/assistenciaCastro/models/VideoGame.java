package br.com.assistenciaCastro.models;

import br.com.assistenciaCastro.enums.StatusConserto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class VideoGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String marca;
    @NotNull
    private String modelo;
    @NotNull
    private String defeito;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private StatusConserto status = StatusConserto.RECEBIDO;

    public VideoGame() {
    }

    public VideoGame(String marca, String modelo, String defeito, Cliente cliente, StatusConserto status) {
        this.marca = marca;
        this.modelo = modelo;
        this.defeito = defeito;
        this.cliente = cliente;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusConserto getStatus() {
        return status;
    }

    public void setStatus(StatusConserto status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", defeito='" + defeito + '\'' +
                ", cliente=" + cliente +
                ", status=" + status +
                '}';
    }
}
