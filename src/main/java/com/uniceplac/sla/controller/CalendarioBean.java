
package com.uniceplac.sla.controller;

import com.uniceplac.sla.dao.CalendarioDao;
import com.uniceplac.sla.model.EventoCalendario;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Named("calendarioBean")
@ViewScoped
public class CalendarioBean implements Serializable {

    private List<EventoCalendario> eventos;

    @Autowired
    private transient CalendarioDao calendarioDao;

    @PostConstruct
    public void init() {
        this.eventos = calendarioDao.listarProximosEventos();
    }

    public List<EventoCalendario> getEventos() { return eventos; }
}
