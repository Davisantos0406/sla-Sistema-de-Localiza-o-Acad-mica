package com.uniceplac.sla.model;

public class Clube {

    private Long id;
    private String nome;
    private String categoria;
    private String descricao;
    private String lider;

    public Clube() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getLider() { return lider; }
    public void setLider(String lider) { this.lider = lider; }
}
