package com.inmobicasaventas.gestinmo.api.domain.clients;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TypeClient")
@Table(name = "type_of_client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientType {
    @Id
    private Integer id;
    private String type;
}
