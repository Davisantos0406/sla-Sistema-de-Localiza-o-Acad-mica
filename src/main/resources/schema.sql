CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(100),
    senha VARCHAR(100),
    perfil_id BIGINT
);

CREATE TABLE IF NOT EXISTS sala (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    bloco VARCHAR(10),
    numero VARCHAR(10),
    tipo VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS disciplina (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS alocacao (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    usuario_id BIGINT,
    disciplina_id BIGINT,
    sala_id BIGINT,
    horario VARCHAR(50),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (disciplina_id) REFERENCES disciplina(id),
    FOREIGN KEY (sala_id) REFERENCES sala(id)
);

-- Inserindo dados de teste (Aluno e Professor)
INSERT INTO usuario (id, nome, email, senha, perfil_id) VALUES (1, 'João Aluno', 'aluno@uniceplac.com', '123', 1);
INSERT INTO usuario (id, nome, email, senha, perfil_id) VALUES (2, 'Prof Carlos', 'professor@uniceplac.com', '123', 2);

INSERT INTO sala (id, bloco, numero, tipo) VALUES (1, 'Bloco A', '101', 'TEORICA');
INSERT INTO sala (id, bloco, numero, tipo) VALUES (2, 'Bloco B', '202', 'LABORATORIO');

INSERT INTO disciplina (id, nome) VALUES (1, 'Engenharia de Software');
INSERT INTO disciplina (id, nome) VALUES (2, 'Banco de Dados');

INSERT INTO alocacao (usuario_id, disciplina_id, sala_id, horario) VALUES (1, 1, 1, 'Segunda 19:00');
INSERT INTO alocacao (usuario_id, disciplina_id, sala_id, horario) VALUES (2, 2, 2, 'Terça 20:30');