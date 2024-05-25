package com.inmobicasaventas.gestinmo.api.offers.domain.models;

import java.time.LocalDate;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

import jakarta.persistence.Entity;
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

@Entity(name = "Offer")
@Table(name = "offers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    private Property property;
    private Long price;
    private LocalDate creationDate;
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "catchment_type", referencedColumnName = "id")
    private CatchmentType catchmentType;
}
