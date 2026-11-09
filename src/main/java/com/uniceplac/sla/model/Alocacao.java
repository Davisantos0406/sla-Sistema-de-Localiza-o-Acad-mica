 package com.uniceplac.sla.model;

public class Alocacao {
    private Long id;
    private Long usuarioId;
    private Long disciplinaId;
    private Long salaId;
    private String horario;

    public Alocacao() {}

    public Alocacao(Long id, Long usuarioId, Long disciplinaId, Long salaId, String horario) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.disciplinaId = disciplinaId;
        this.salaId = salaId;
        this.horario = horario;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getDisciplinaId() { return disciplinaId; }
    public void setDisciplinaId(Long disciplinaId) { this.disciplinaId = disciplinaId; }

    public Long getSalaId() { return salaId; }
    public void setSalaId(Long salaId) { this.salaId = salaId; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
}
