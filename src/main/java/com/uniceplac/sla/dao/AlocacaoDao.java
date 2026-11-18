package com.uniceplac.sla.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uniceplac.sla.model.Alocacao;

@Repository
public class AlocacaoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> buscarAlocacoesPorUsuario(Long usuarioId) {

        String sql = "SELECT d.nome AS disciplina, s.bloco, s.numero, s.tipo, " +
                     "a.dia_semana, a.horario_inicio, a.horario_fim, u.nome AS professor " +
                     "FROM alocacoes a " +
                     "INNER JOIN disciplinas d ON a.disciplina_id = d.id " +
                     "INNER JOIN salas s ON a.sala_id = s.id " +
                     "INNER JOIN usuarios u ON a.professor_id = u.id " +
                     "WHERE a.professor_id = ? OR ? = 1";

        return jdbcTemplate.queryForList(sql, usuarioId, usuarioId);
    }

    public void salvar(Alocacao alocacao) {
        String sql = "INSERT INTO alocacoes (disciplina_id, professor_id, sala_id, dia_semana, horario_inicio, horario_fim) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
            sql,
            alocacao.getDisciplinaId(),
            alocacao.getProfessorId(),
            alocacao.getSalaId(),
            alocacao.getDiaSemana(),
            alocacao.getHorarioInicio(),
            alocacao.getHorarioFim()
        );
    }
}
