CREATE TABLE advisors (
    id INTEGER primary key,
    name TEXT NOT NULL,
    password TEXT NOT NULL,
    login TEXT NOT NULL UNIQUE
);