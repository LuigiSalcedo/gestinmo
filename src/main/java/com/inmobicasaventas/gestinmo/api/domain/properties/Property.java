package com.inmobicasaventas.gestinmo.api.domain.properties;

import com.inmobicasaventas.gestinmo.api.domain.clients.Client;
import com.inmobicasaventas.gestinmo.api.domain.properties.neighborhoods.Neighborhood;
import com.inmobicasaventas.gestinmo.api.domain.properties.types.PropertyType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "properties")
@Data
@EqualsAndHashCode(of = "id")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "neighborhood", referencedColumnName = "id")
    private Neighborhood neighborhood;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type", referencedColumnName = "id")
    private PropertyType type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_owner", referencedColumnName = "id")
    private Client clientOwner;

    private String observation;
}
