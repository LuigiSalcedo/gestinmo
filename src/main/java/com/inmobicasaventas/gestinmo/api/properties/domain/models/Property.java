package com.inmobicasaventas.gestinmo.api.properties.domain.models;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "properties")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
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

    private String observations;
    private Boolean active;
}
