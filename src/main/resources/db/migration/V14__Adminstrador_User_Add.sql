CREATE TABLE administrators(
    ID SERIAL,
    NAME TEXT NOT NULL UNIQUE,
    PASSWORD TEXT NOT NULL
);

INSERT INTO administrators(name, password) VALUES(
    'gestinmo_advisors_admin', '$2a$12$P/wFkm/M/nql43ayCzk.de9fv7nx8FnqCp6yJ0OaFBRNA2a1vzmz.'
)