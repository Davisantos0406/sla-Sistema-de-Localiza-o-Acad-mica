package com.uniceplac.sla.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniceplac.sla.dao.UsuarioDao;
import com.uniceplac.sla.model.Usuario;

@Service
public class AuthService {

    @Autowired
    private UsuarioDao usuarioDao;

    public Usuario autenticar(String email, String senha) {
        Usuario usuario = usuarioDao.buscarPorEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }

    public List<Map<String, Object>> obterAlocacoes(Long usuarioId) {
        return usuarioDao.buscarAlocacaoPorUsuario(usuarioId);
    }
}