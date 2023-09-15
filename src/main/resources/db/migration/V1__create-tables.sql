CREATE TABLE pessoa (
  id BIGINT AUTO_INCREMENT PRIMARY KEY UNIQUE,
  apelido VARCHAR(255),
  nome VARCHAR(255),
  nascimento DATE
);

CREATE TABLE stack (
  pessoa_id BIGINT,
  tecnologia VARCHAR(255)
);