package com.uniceplac.sla.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uniceplac.sla.dao.AlocacaoDao;
import com.uniceplac.sla.dao.DisciplinaDao;
import com.uniceplac.sla.dao.SalaDao;
import com.uniceplac.sla.model.Alocacao;
import com.uniceplac.sla.model.Disciplina;
import com.uniceplac.sla.model.Sala;
import com.uniceplac.sla.model.Usuario;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("professorAulaBean")
@ViewScoped
public class ProfessorAulaBean implements Serializable {

    private Alocacao novaAula = new Alocacao();
    private List<Disciplina> disciplinas;
    private List<Sala> salas;

    @Autowired
    private transient DisciplinaDao disciplinaDao;

    @Autowired
    private transient SalaDao salaDao;

    @Autowired
    private transient AlocacaoDao alocacaoDao;

    @PostConstruct
    public void init() {
        carregarOpcoes();
    }

    public void carregarOpcoes() {
        disciplinas = disciplinaDao.listarTodas();
        salas = salaDao.listarTodas();
    }

    public String salvarAula() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        LoginBean loginBean = (LoginBean) facesContext.getExternalContext().getSessionMap().get("loginBean");

        if (loginBean == null || loginBean.getUsuarioLogado() == null) {
            return "/login.xhtml?faces-redirect=true";
        }

        Usuario usuarioLogado = loginBean.getUsuarioLogado();

        if (novaAula.getDisciplinaId() == null || novaAula.getSalaId() == null ||
                novaAula.getDiaSemana() == null || novaAula.getHorarioInicio() == null ||
                novaAula.getHorarioFim() == null || novaAula.getDiaSemana().trim().isEmpty() ||
                novaAula.getHorarioInicio().trim().isEmpty() || novaAula.getHorarioFim().trim().isEmpty()) {

            facesContext.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dados incompletos", "Preencha todos os campos para cadastrar a aula."));
            return null;
        }

        novaAula.setProfessorId(usuarioLogado.getId());
        alocacaoDao.salvar(novaAula);
        loginBean.carregarAlocacoes();
        novaAula = new Alocacao();

        facesContext.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Aula cadastrada com sucesso."));
        facesContext.getExternalContext().getFlash().setKeepMessages(true);

        return "/professor/painel.xhtml?faces-redirect=true";
    }

    public Alocacao getNovaAula() {
        return novaAula;
    }

    public void setNovaAula(Alocacao novaAula) {
        this.novaAula = novaAula;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Sala> getSalas() {
        return salas;
    }
}
