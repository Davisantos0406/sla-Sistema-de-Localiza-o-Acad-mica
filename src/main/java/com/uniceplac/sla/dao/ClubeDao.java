package com.uniceplac.sla.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uniceplac.sla.model.Clube;

@Repository
public class ClubeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Clube> clubeMapper = (rs, rowNum) -> {

        Clube c = new Clube();

        c.setId(rs.getLong("id"));
        c.setNome(rs.getString("nome"));
        c.setCategoria(rs.getString("categoria"));
        c.setDescricao(rs.getString("descricao"));
        c.setLider(rs.getString("lider"));

        return c;
    };

    public List<Clube> listarTodos() {

        String sql = "SELECT * FROM clubes ORDER BY nome";

        return jdbcTemplate.query(sql, clubeMapper);
    }
}
