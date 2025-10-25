package br.com.assistenciaCastro.enums;

public enum StatusConserto {
    RECEBIDO(0),
    EM_CONSERTO(1),
    CONCLUIDO(2),
    ENTREGUE(3);

    private Integer codigo;

    StatusConserto(Integer codigo) {
        this.codigo = codigo;
    }
}
