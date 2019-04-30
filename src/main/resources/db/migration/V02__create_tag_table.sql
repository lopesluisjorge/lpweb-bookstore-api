CREATE TABLE tag (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  tag VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY (id));

INSERT INTO tag
  (name, tag)
VALUES
  ('Eletrônica', 'eletronica'),
  ('Banco de Dados', 'bd'),
  ('Redes de Computadores', 'redes'),
  ('Internet', 'internet'),
  ('Algoritmos', 'algoritmos'),
  ('Desenvolvimento Web', 'web'),
  ('Desenvolvimento Mobile', 'mobile'),
  ('Android', 'android'),
  ('Inteligência Artificial', 'ia'),
  ('Python 3', 'python3');
