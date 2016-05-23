USE jooq;

INSERT INTO author (first_name, last_name, date_of_birth)
VALUES ('George', 'Orwell', '1903-06-25');
INSERT INTO author (first_name, last_name, date_of_birth)
VALUES ('Paulo', 'Coelho', '1947-08-24');

INSERT INTO book VALUES (1, 1, '1984', 1948, NULL);
INSERT INTO book VALUES (2, 1, 'Animal Farm', 1945, NULL);
INSERT INTO book VALUES (3, 2, 'O Alquimista', 1988, NULL);
INSERT INTO book VALUES (4, 2, 'Brida', 1990, NULL);

INSERT INTO book_store (name) VALUES
    ('Amazon'),
    ('Barnes and Noble'),
    ('Payot');

INSERT INTO book_to_book_store VALUES
    ('Amazon', 1, 10),
    ('Amazon', 2, 10),
    ('Amazon', 3, 10),
    ('Barnes and Noble', 1, 1),
    ('Barnes and Noble', 3, 2),
    ('Payot', 3, 1);

