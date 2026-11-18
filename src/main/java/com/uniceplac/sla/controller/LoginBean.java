package com.uniceplac.sla.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.uniceplac.sla.model.Usuario;
import com.uniceplac.sla.service.AuthService;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("loginBean")
@SessionScoped
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
            this.alocacoes = authService.buscarAlocacoes(u.getId());

            if ("COORDENADOR".equals(u.getPerfilNome())) {
                return "/coordenacao/painel.xhtml?faces-redirect=true";
            } else if ("PROFESSOR".equals(u.getPerfilNome())) {
                return "/professor/painel.xhtml?faces-redirect=true";
            } else {
                return "/aluno/painel.xhtml?faces-redirect=true";
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Erro no Login",
                    "E-mail ou senha incorretos!"
                )
            );

            return null;
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

    public void carregarAlocacoes() {
        if (usuarioLogado != null && authService != null) {
            this.alocacoes = authService.buscarAlocacoes(usuarioLogado.getId());
        }
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Usuario getUsuarioLogado() { return usuarioLogado; }

    public List<Map<String, Object>> getAlocacoes() { return alocacoes; }
    public void setAlocacoes(List<Map<String, Object>> alocacoes) { this.alocacoes = alocacoes; }
}
