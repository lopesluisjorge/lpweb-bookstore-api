ALTER TABLE book_tag DROP CONSTRAINT book_tag_book_id_key;
ALTER TABLE book_tag DROP CONSTRAINT book_tag_tag_id_key;

ALTER TABLE book_tag ADD PRIMARY KEY (book_id, tag_id);
