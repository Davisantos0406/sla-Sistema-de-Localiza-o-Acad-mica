package com.uniceplac.sla.dao;

import com.uniceplac.sla.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Usuario> usuarioMapper = (rs, rowNum) -> {

        Usuario u = new Usuario();

        u.setId(rs.getLong("id"));
        u.setMatricula(rs.getString("matricula"));
        u.setNome(rs.getString("nome"));
        u.setEmail(rs.getString("email"));
        u.setSenha(rs.getString("senha"));
        u.setPerfilId(rs.getLong("perfil_id"));
        u.setPerfilNome(rs.getString("perfil_nome"));

        return u;
    };

    public Usuario buscarPorEmail(String email) {

        String sql = "SELECT u.*, p.nome AS perfil_nome " +
                     "FROM usuarios u " +
                     "INNER JOIN perfis p ON u.perfil_id = p.id " +
                     "WHERE u.email = ?";

        List<Usuario> resultados = jdbcTemplate.query(sql, usuarioMapper, email);

        return resultados.isEmpty() ? null : resultados.get(0);
    }
}
