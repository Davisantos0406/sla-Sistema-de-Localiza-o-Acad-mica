MERGE INTO perfis (id, nome)
KEY(id) VALUES (1, 'ALUNO');

MERGE INTO perfis (id, nome)
KEY(id) VALUES (2, 'PROFESSOR');

MERGE INTO perfis (id, nome)
KEY(id) VALUES (3, 'COORDENADOR');



INSERT INTO usuarios (id, matricula, nome, email, senha, perfil_id)
SELECT 1, 'ALU001', 'Lucas Silva',
       'aluno@uniceplac.edu.br', '123', 1
WHERE NOT EXISTS (
    SELECT 1 FROM usuarios WHERE id = 1
);

INSERT INTO usuarios (id, matricula, nome, email, senha, perfil_id)
SELECT 2, 'PRF001', 'Prof. Carlos Eduardo',
       'professor@uniceplac.edu.br', '123', 2
WHERE NOT EXISTS (
    SELECT 1 FROM usuarios WHERE id = 2
);

INSERT INTO usuarios (id, matricula, nome, email, senha, perfil_id)
SELECT 3, 'CRD001', 'Coord. Maria Fernanda',
       'coordenacao@uniceplac.edu.br', '123', 3
WHERE NOT EXISTS (
    SELECT 1 FROM usuarios WHERE id = 3
);




INSERT INTO salas (id, bloco, numero, tipo, capacidade, descricao)
SELECT 1, 'Bloco A', '101', 'TEORICA', 50,
       'Sala Teórica de Computação'
WHERE NOT EXISTS (
    SELECT 1 FROM salas WHERE id = 1
);

INSERT INTO salas (id, bloco, numero, tipo, capacidade, descricao)
SELECT 2, 'Bloco A', '102', 'TEORICA', 50,
       'Sala Teórica de Engenharia'
WHERE NOT EXISTS (
    SELECT 1 FROM salas WHERE id = 2
);

INSERT INTO salas (id, bloco, numero, tipo, capacidade, descricao)
SELECT 3, 'Bloco A', '103', 'TEORICA', 45,
       'Sala de Aulas de Sistemas'
WHERE NOT EXISTS (
    SELECT 1 FROM salas WHERE id = 3
);

INSERT INTO salas (id, bloco, numero, tipo, capacidade, descricao)
SELECT 4, 'Bloco A', '104', 'LABORATORIO', 35,
       'Laboratório de Programação'
WHERE NOT EXISTS (
    SELECT 1 FROM salas WHERE id = 4
);

INSERT INTO salas (id, bloco, numero, tipo, capacidade, descricao)
SELECT 5, 'Bloco A', '105', 'LABORATORIO', 30,
       'Laboratório de Hardware e Redes'
WHERE NOT EXISTS (
    SELECT 1 FROM salas WHERE id = 5
);

INSERT INTO salas (id, bloco, numero, tipo, capacidade, descricao)
SELECT 6, 'Bloco B', 'Lab 03', 'LABORATORIO', 30,
       'Laboratório de Software'
WHERE NOT EXISTS (
    SELECT 1 FROM salas WHERE id = 6
);




INSERT INTO disciplinas (id, codigo, nome, carga_horaria)
SELECT 1, 'ENG01', 'Engenharia de Software', 80
WHERE NOT EXISTS (
    SELECT 1 FROM disciplinas WHERE id = 1
);

INSERT INTO disciplinas (id, codigo, nome, carga_horaria)
SELECT 2, 'BD02', 'Banco de Dados Relacional', 80
WHERE NOT EXISTS (
    SELECT 1 FROM disciplinas WHERE id = 2
);

INSERT INTO disciplinas (id, codigo, nome, carga_horaria)
SELECT 3, 'ES01', 'Estruturas de Dados', 80
WHERE NOT EXISTS (
    SELECT 1 FROM disciplinas WHERE id = 3
);

INSERT INTO disciplinas (id, codigo, nome, carga_horaria)
SELECT 4, 'ES02', 'Algoritmos e Programação', 80
WHERE NOT EXISTS (
    SELECT 1 FROM disciplinas WHERE id = 4
);

INSERT INTO disciplinas (id, codigo, nome, carga_horaria)
SELECT 5, 'ES03', 'Arquitetura de Software', 80
WHERE NOT EXISTS (
    SELECT 1 FROM disciplinas WHERE id = 5
);

INSERT INTO disciplinas (id, codigo, nome, carga_horaria)
SELECT 6, 'ES04', 'Qualidade de Software', 60
WHERE NOT EXISTS (
    SELECT 1 FROM disciplinas WHERE id = 6
);




INSERT INTO alocacoes (
    id, disciplina_id, professor_id, sala_id,
    dia_semana, horario_inicio, horario_fim
)
SELECT 1, 1, 2, 1, 'Segunda-feira', '19:00', '20:40'
WHERE NOT EXISTS (
    SELECT 1 FROM alocacoes WHERE id = 1
);

INSERT INTO alocacoes (
    id, disciplina_id, professor_id, sala_id,
    dia_semana, horario_inicio, horario_fim
)
SELECT 2, 2, 2, 2, 'Terça-feira', '20:50', '22:30'
WHERE NOT EXISTS (
    SELECT 1 FROM alocacoes WHERE id = 2
);




INSERT INTO clubes (id, nome, categoria, descricao, lider)
SELECT 1, 'Clube de Robótica & IoT', 'Tecnologia',
       'Projetos práticos de robótica e automação.',
       'Prof. Carlos'
WHERE NOT EXISTS (
    SELECT 1 FROM clubes WHERE id = 1
);




INSERT INTO clubes (id, nome, categoria, descricao, lider)
SELECT 2, 'Liga de Algoritmos', 'Programação',
       'Estudos de algoritmos, lógica e desafios de programação.',
       'Prof. Ricardo'
WHERE NOT EXISTS (
    SELECT 1 FROM clubes WHERE id = 2
);




INSERT INTO clubes (id, nome, categoria, descricao, lider)
SELECT 3, 'Clube de Segurança da Informação', 'Segurança',
       'Estudos de cibersegurança, proteção de dados e redes.',
       'Prof. André'
WHERE NOT EXISTS (
    SELECT 1 FROM clubes WHERE id = 3
);




INSERT INTO clubes (id, nome, categoria, descricao, lider)
SELECT 4, 'Clube de Inteligência Artificial', 'Inteligência Artificial',
       'Projetos de inteligência artificial e aprendizado de máquina.',
       'Prof. Fernanda'
WHERE NOT EXISTS (
    SELECT 1 FROM clubes WHERE id = 4
);



INSERT INTO clubes (id, nome, categoria, descricao, lider)
SELECT 5, 'Clube de Redes e Infraestrutura', 'Infraestrutura',
       'Atividades sobre redes, servidores e infraestrutura de TI.',
       'Prof. Marcelo'
WHERE NOT EXISTS (
    SELECT 1 FROM clubes WHERE id = 5
);




INSERT INTO clubes (id, nome, categoria, descricao, lider)
SELECT 6, 'Clube de Desenvolvimento de Jogos', 'Desenvolvimento de Jogos',
       'Criação de jogos digitais e experiências interativas.',
       'Prof. Gustavo'
WHERE NOT EXISTS (
    SELECT 1 FROM clubes WHERE id = 6
);




INSERT INTO clubes (id, nome, categoria, descricao, lider)
SELECT 7, 'Clube de Ciência de Dados', 'Dados',
       'Análise de dados, estatística e visualização de informações.',
       'Prof. Juliana'
WHERE NOT EXISTS (
    SELECT 1 FROM clubes WHERE id = 7
);




INSERT INTO clubes (id, nome, categoria, descricao, lider)
SELECT 8, 'Clube de Desenvolvimento Web', 'Programação',
       'Desenvolvimento de sites e aplicações web.',
       'Prof. Rafael'
WHERE NOT EXISTS (
    SELECT 1 FROM clubes WHERE id = 8
);




INSERT INTO clubes (id, nome, categoria, descricao, lider)
SELECT 9, 'Clube de Desenvolvimento Mobile', 'Tecnologia',
       'Criação de aplicativos para dispositivos móveis.',
       'Prof. Beatriz'
WHERE NOT EXISTS (
    SELECT 1 FROM clubes WHERE id = 9
);




INSERT INTO clubes (id, nome, categoria, descricao, lider)
SELECT 10, 'Clube de Inovação e Empreendedorismo', 'Inovação',
       'Desenvolvimento de ideias, projetos e soluções inovadoras.',
       'Prof. Eduardo'
WHERE NOT EXISTS (
    SELECT 1 FROM clubes WHERE id = 10
);



INSERT INTO eventos_calendario (
    id, titulo, data_evento, tipo, descricao
)
SELECT 1, 'Avaliação Regimental (P1)',
       DATE '2026-11-20', 'PROVA',
       'Avaliação Bimestral de Engenharia de Software.'
WHERE NOT EXISTS (
    SELECT 1 FROM eventos_calendario WHERE id = 1
);
