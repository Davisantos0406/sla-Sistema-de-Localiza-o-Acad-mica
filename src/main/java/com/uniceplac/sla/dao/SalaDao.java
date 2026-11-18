package com.uniceplac.sla.dao;

import com.uniceplac.sla.model.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Sala> salaMapper = (rs, rowNum) -> {

        Sala s = new Sala();

        s.setId(rs.getLong("id"));
        s.setBloco(rs.getString("bloco"));
        s.setNumero(rs.getString("numero"));
        s.setTipo(rs.getString("tipo"));
        s.setCapacidade(rs.getInt("capacidade"));
        s.setDescricao(rs.getString("descricao"));

        return s;
    };

    public List<Sala> listarTodas() {

        String sql = "SELECT * FROM salas ORDER BY bloco, numero";

        return jdbcTemplate.query(sql, salaMapper);
    }

    public void salvar(Sala sala) {

        String sql = "INSERT INTO salas (bloco, numero, tipo, capacidade, descricao) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(
            sql,
            sala.getBloco(),
            sala.getNumero(),
            sala.getTipo(),
            sala.getCapacidade(),
            sala.getDescricao()
        );
    }
}
