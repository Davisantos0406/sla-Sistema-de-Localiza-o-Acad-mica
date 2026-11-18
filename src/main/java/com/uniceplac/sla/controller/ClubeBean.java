package com.uniceplac.sla.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uniceplac.sla.dao.ClubeDao;
import com.uniceplac.sla.model.Clube;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("clubeBean")
@ViewScoped
public class ClubeBean implements Serializable {

    private List<Clube> clubes;

    @Autowired
    private transient ClubeDao clubeDao;

    @PostConstruct
    public void init() {
        this.clubes = clubeDao.listarTodos();
    }

    public List<Clube> getClubes() { return clubes; }
}
