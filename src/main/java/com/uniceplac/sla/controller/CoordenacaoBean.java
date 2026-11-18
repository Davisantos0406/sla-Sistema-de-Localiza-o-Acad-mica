package com.uniceplac.sla.controller;

import com.uniceplac.sla.dao.SalaDao;
import com.uniceplac.sla.model.Sala;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Named("coordenacaoBean")
@ViewScoped
public class CoordenacaoBean implements Serializable {

    private Sala novaSala = new Sala();
    private List<Sala> salas;

    @Autowired
    private transient SalaDao salaDao;

    @PostConstruct
    public void init() {
        carregarSalas();
    }

    public void carregarSalas() {
        this.salas = salaDao.listarTodas();
    }

    public void cadastrarSala() {
        salaDao.salvar(novaSala);
        novaSala = new Sala();
        carregarSalas();

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Novo ambiente cadastrado com sucesso!"));
    }

    public Sala getNovaSala() { return novaSala; }
    public void setNovaSala(Sala novaSala) { this.novaSala = novaSala; }

    public List<Sala> getSalas() { return salas; }
}
