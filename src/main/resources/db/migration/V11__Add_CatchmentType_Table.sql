CREATE TABLE catchment_types(
    ID SERIAL PRIMARY KEY,
    NAME TEXT NOT NULL
);

INSERT INTO catchment_types(name) VALUES ('VENTA'), ('ARRIENDO');