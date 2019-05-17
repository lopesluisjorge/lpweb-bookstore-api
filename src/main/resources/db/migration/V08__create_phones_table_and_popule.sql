CREATE TABLE phones (
  customer_id BIGINT NOT NULL,
  number VARCHAR(11),
  FOREIGN KEY (customer_id) REFERENCES customer(id));

INSERT INTO phones
  (customer_id, number)
VALUES
  (1, '98988887777'),
  (1, '98988778877'),
  (2, '98988779900'),
  (3, '98988857977'),
  (4, '98987887878'),
  (5, '98988287978'),
  (6, '98988485970');
