package com.uniceplac.sla.dao;

import com.uniceplac.sla.model.EventoCalendario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CalendarioDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<EventoCalendario> eventoMapper = (rs, rowNum) -> {

        EventoCalendario e = new EventoCalendario();

        e.setId(rs.getLong("id"));
        e.setTitulo(rs.getString("titulo"));
        e.setDataEvento(rs.getDate("data_evento").toLocalDate());
        e.setTipo(rs.getString("tipo"));
        e.setDescricao(rs.getString("descricao"));

        return e;
    };

    public List<EventoCalendario> listarProximosEventos() {

        String sql = "SELECT * FROM eventos_calendario ORDER BY data_evento ASC";

        return jdbcTemplate.query(sql, eventoMapper);
    }
}
