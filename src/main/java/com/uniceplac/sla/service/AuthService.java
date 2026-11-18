package com.uniceplac.sla.service;

import com.uniceplac.sla.dao.AlocacaoDao;
import com.uniceplac.sla.dao.UsuarioDao;
import com.uniceplac.sla.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private AlocacaoDao alocacaoDao;

    public Usuario autenticar(String email, String senha) {

        Usuario u = usuarioDao.buscarPorEmail(email);

        if (u != null && u.getSenha().equals(senha)) {
            return u;
        }

        return null;
    }

    public List<Map<String, Object>> buscarAlocacoes(Long usuarioId) {
        return alocacaoDao.buscarAlocacoesPorUsuario(usuarioId);
    }
}
