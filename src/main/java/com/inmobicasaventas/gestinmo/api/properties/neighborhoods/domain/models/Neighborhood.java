package com.inmobicasaventas.gestinmo.api.properties.neighborhoods.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "neighborhoods")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Neighborhood {
    @Id
    private Integer id;
    private String name;
}
