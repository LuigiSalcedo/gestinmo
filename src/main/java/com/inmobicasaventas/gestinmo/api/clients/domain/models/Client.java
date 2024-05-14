package com.inmobicasaventas.gestinmo.api.clients.domain.models;

import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.SaveClientDto;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.UpdateClientDto;

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
    @JoinColumn(name = "type", referencedColumnName = "id")
    private ClientType type;

    // Convert to SaveClient JSON to Client Object
    public Client(SaveClientDto client) {
        this.id = client.id();
        this.name = client.name();
        this.phoneNumber = client.phoneNumber();
        this.email = client.email();
        this.type = new ClientType(client.type(), "");
    }

    // Converto to UpdateClient JSON to Client Object
    public Client(UpdateClientDto client) {
        this.name = client.name();
        this.email = client.email();
        this.phoneNumber = client.phoneNumber();
        if(client.type() != null) {
            this.type = new ClientType(client.type(), "");
        }
    }
}
