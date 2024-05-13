package com.inmobicasaventas.gestinmo.api.properties.types.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "type_of_property")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyType {
    @Id
    private Integer id;
    private String name;
}
