CREATE TABLE item_rental (
  item_id BIGINT NOT NULL,
  rental_id BIGINT NOT NULL,
  rental_price NUMERIC(10, 2),
  discount NUMERIC(5, 2) CHECK (discount<=99 AND discount>=0),
  rental_date DATE NOT NULL,
  return_date DATE,
  PRIMARY KEY (item_id, rental_id),
  FOREIGN KEY (item_id) REFERENCES item,
  FOREIGN KEY (rental_id) REFERENCES rental);
