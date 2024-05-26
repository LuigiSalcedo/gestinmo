package com.inmobicasaventas.gestinmo.api.documents.infrastructure.configurations;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class StorageConfiguration {
    private String location = "files";
}
