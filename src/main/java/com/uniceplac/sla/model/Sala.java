package com.uniceplac.sla.model;

public class Sala {
    private Long id;
    private String bloco;
    private String numero;
    private String tipo; // 'TEORICA' ou 'LABORATORIO'

    public Sala() {}

    public Sala(Long id, String bloco, String numero, String tipo) {
        this.id = id;
        this.bloco = bloco;
        this.numero = numero;
        this.tipo = tipo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBloco() { return bloco; }
    public void setBloco(String bloco) { this.bloco = bloco; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}