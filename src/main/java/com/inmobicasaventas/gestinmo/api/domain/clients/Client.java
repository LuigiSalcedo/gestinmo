package com.inmobicasaventas.gestinmo.api.domain.clients;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Client")
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Client {
    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private TypeClient type;
}
