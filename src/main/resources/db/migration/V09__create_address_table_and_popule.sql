CREATE TABLE address (
  customer_id BIGINT,
  cep VARCHAR(255),
  street VARCHAR(255),
  number VARCHAR(255),
  neighborhood VARCHAR(255),
  city VARCHAR(255),
  state VARCHAR(255),
  complement TEXT,
  PRIMARY KEY (customer_id),
  FOREIGN KEY (customer_id) REFERENCES customer(id));

INSERT INTO address
  (customer_id, cep, street, number, neighborhood, city, state)
VALUES
  (1, 65042010, 'Rua 3, Qd 17', '5', 'Filipinho', 'São Luis', 'MA'),
  (2, 65057360, 'Rua São Camilo', '54', 'João de Deus', 'São Luis', 'MA'),
  (3, 65000000, 'Rua 3', '50', 'Matões Turu', 'São Luis', 'MA'),
  (4, 65057360, 'Rua São Camilo', '48', 'João de Deus', 'São Luis', 'MA'),
  (5, 65000000, 'Av 2', '480', 'São Bernardo', 'São Luis', 'MA'),
  (6, 65046770, 'Rua São João', '56', 'Pão de Açucar', 'São Luis', 'MA');
