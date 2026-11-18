package com.uniceplac.sla.model;

public class Sala {

    private Long id;
    private String bloco;
    private String numero;
    private String tipo;
    private Integer capacidade;
    private String descricao;

    public Sala() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBloco() { return bloco; }
    public void setBloco(String bloco) { this.bloco = bloco; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
