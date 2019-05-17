CREATE TABLE customer (
  id BIGSERIAL,
  name VARCHAR(255),
  cpf VARCHAR(14),
  birthdate DATE,
  email VARCHAR(127),
  PRIMARY KEY (id)
);

INSERT INTO customer
  (name, cpf, birthdate, email)
VALUES 
  ('João da Silva', '33490411080', '1996-02-24', 'joao@email.com'),
  ('Jaime', '86182792000', '1996-02-24', 'jaime@email.com'),
  ('Mariana', '20083991093', '1982-03-02', 'mariana@email.com'),
  ('Flávia', '63474675001', '1997-03-01', 'flavia@email.com'),
  ('Marcos Augusto Maciel', '22708474073', '1996-05-14', 'marcos@email.com'),
  ('Ana Lívia', '17528324000', '1986-11-21', 'ana@email.com');
