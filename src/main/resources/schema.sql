
CREATE TABLE IF NOT EXISTS perfis (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(20) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    perfil_id BIGINT NOT NULL,
    FOREIGN KEY (perfil_id) REFERENCES perfis(id)
);

CREATE TABLE IF NOT EXISTS salas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    bloco VARCHAR(10) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    capacidade INT NOT NULL,
    descricao VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS disciplinas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    carga_horaria INT NOT NULL
);

CREATE TABLE IF NOT EXISTS alocacoes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    disciplina_id BIGINT NOT NULL,
    professor_id BIGINT NOT NULL,
    sala_id BIGINT NOT NULL,
    dia_semana VARCHAR(20) NOT NULL,
    horario_inicio VARCHAR(10) NOT NULL,
    horario_fim VARCHAR(10) NOT NULL,
    FOREIGN KEY (disciplina_id) REFERENCES disciplinas(id),
    FOREIGN KEY (professor_id) REFERENCES usuarios(id),
    FOREIGN KEY (sala_id) REFERENCES salas(id)
);

CREATE TABLE IF NOT EXISTS clubes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    descricao TEXT,
    lider VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS eventos_calendario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    data_evento DATE NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    descricao VARCHAR(255)
);
