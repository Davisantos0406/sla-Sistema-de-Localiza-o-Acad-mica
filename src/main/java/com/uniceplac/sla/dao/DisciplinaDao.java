package com.uniceplac.sla.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uniceplac.sla.model.Disciplina;

@Repository
public class DisciplinaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Disciplina> disciplinaMapper = (rs, rowNum) -> {
        Disciplina d = new Disciplina();
        d.setId(rs.getLong("id"));
        d.setCodigo(rs.getString("codigo"));
        d.setNome(rs.getString("nome"));
        d.setCargaHoraria(rs.getInt("carga_horaria"));
        return d;
    };

    public List<Disciplina> listarTodas() {
        String sql = "SELECT * FROM disciplinas ORDER BY nome";
        return jdbcTemplate.query(sql, disciplinaMapper);
    }
}
