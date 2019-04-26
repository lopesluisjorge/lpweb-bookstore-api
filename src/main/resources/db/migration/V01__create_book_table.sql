CREATE TABLE book (
  id BIGSERIAL,
  isbn VARCHAR(255) NOT NULL UNIQUE,
  title VARCHAR(255) NOT NULL,
  publishing_company VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  release_year INT NOT NULL,
  subject text,
  PRIMARY KEY (id));

INSERT INTO book
  (isbn, title, publishing_company, author, release_year)
VALUES
  ('ISBN 0-321-12521-5', 'Domain-driven design : tackling complexity in the heart of software', 'Addison-Wesley', 'Eric Evans', 2004),
  ('ISBN 978-1-617-29199-9', 'Java 8 in Action', 'Manning Publications', 'Alan Mycroft', 2015),
  ('ISBN 0-7356-1967-0', 'Code Complete - 2nd Ed', 'Microsoft Press', 'Steven C. McConnell', 2004),
  ('ISBN 978-1-449-37319-1', 'PostgreSQL: Up and Running, Second Edition', 'OReilly', 'Regina O. Obe', 2015);
