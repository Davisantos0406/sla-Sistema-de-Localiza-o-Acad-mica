package com.uniceplac.sla.dao;

import com.uniceplac.sla.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class UsuarioDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Usuario> rowMapper = new RowMapper<Usuario>() {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario u = new Usuario();
            u.setId(rs.getLong("id"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));
            u.setSenha(rs.getString("senha"));
            u.setPerfilId(rs.getLong("perfil_id"));
            return u;
        }
    };

    public Usuario buscarPorEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        List<Usuario> usuarios = jdbcTemplate.query(sql, rowMapper, email);
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }

    public List<Map<String, Object>> buscarAlocacaoPorUsuario(Long usuarioId) {
        String sql = "SELECT d.nome AS disciplina, s.bloco, s.numero, s.tipo, a.horario " +
                     "FROM alocacao a " +
                     "JOIN disciplina d ON a.disciplina_id = d.id " +
                     "JOIN sala s ON a.sala_id = s.id " +
                     "WHERE a.usuario_id = ?";
        return jdbcTemplate.queryForList(sql, usuarioId);
    }
}
