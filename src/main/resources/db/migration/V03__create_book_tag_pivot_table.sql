CREATE TABLE book_tag (
  book_id BIGINT NOT NULL UNIQUE,
  tag_id INT NOT NULL UNIQUE,
  FOREIGN KEY (book_id) REFERENCES book(id),
  FOREIGN KEY (tag_id) REFERENCES tag(id));

INSERT INTO book_tag
  (book_id, tag_id)
VALUES
  (4, 2);
