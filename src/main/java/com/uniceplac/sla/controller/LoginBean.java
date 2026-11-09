package com.uniceplac.sla.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.uniceplac.sla.model.Usuario;
import com.uniceplac.sla.service.AuthService;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Component("loginBean")
@SessionScope
public class LoginBean implements Serializable {

    private String email;
    private String senha;
    private Usuario usuarioLogado;
    private List<Map<String, Object>> alocacoes;

    @Autowired
    private transient AuthService authService;

    public String fazerLogin() {
        Usuario u = authService.autenticar(email, senha);
        if (u != null) {
            this.usuarioLogado = u;
            this.alocacoes = authService.obterAlocacoes(u.getId());

            if (u.getPerfilId() == 1) {
                return "/aluno/painel.xhtml?faces-redirect=true";
            } else {
                return "/professor/painel.xhtml?faces-redirect=true";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "E-mail ou senha inválidos!"));
            return null;
        }
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Usuario getUsuarioLogado() { return usuarioLogado; }
    public void setUsuarioLogado(Usuario usuarioLogado) { this.usuarioLogado = usuarioLogado; }

    public List<Map<String, Object>> getAlocacoes() { return alocacoes; }
    public void setAlocacoes(List<Map<String, Object>> alocacoes) { this.alocacoes = alocacoes; }
}