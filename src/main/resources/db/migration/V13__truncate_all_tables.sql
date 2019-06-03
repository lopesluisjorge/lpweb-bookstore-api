TRUNCATE TABLE book RESTART IDENTITY CASCADE;
-- NOTICE:  truncate cascades to table "book_tag"
-- NOTICE:  truncate cascades to table "item"
-- NOTICE:  truncate cascades to table "item_rental"

TRUNCATE TABLE tag RESTART IDENTITY CASCADE;

TRUNCATE TABLE customer RESTART IDENTITY CASCADE;
-- NOTICE:  truncate cascades to table "phones"
-- NOTICE:  truncate cascades to table "address"
-- NOTICE:  truncate cascades to table "rental"
-- NOTICE:  truncate cascades to table "item_rental"
