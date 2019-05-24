CREATE TABLE item (
  id BIGSERIAL,
  code VARCHAR(255) NOT NULL UNIQUE,
  rental_price NUMERIC(10, 2),
  status VARCHAR(255),
  book_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (book_id) REFERENCES book);
