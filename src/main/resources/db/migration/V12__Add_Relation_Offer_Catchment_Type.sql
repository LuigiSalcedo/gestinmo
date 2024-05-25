ALTER TABLE offers 
    ADD COLUMN catchment_type INTEGER DEFAULT(1);
    
ALTER TABLE offers 
    ADD FOREIGN KEY(catchment_type) REFERENCES catchment_types(id);