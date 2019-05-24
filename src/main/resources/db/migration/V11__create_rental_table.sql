CREATE TABLE rental (
  id BIGSERIAL,
  customer_id BIGINT,
  total_price NUMERIC(10, 2),
  rental_date DATE,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (customer_id) REFERENCES customer);
