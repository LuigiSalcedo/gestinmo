package com.inmobicasaventas.gestinmo.documentation.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableAutoConfiguration
public class SwaggerConfiguration {
    @Value("${documentation.contact.email}")
    private String contactEmail;
    
    @Value("${documentation.contact.email}")
    private String contactName;

    @Value("${documentation.info.version}")
    private String infoVersion;

    @Bean
    public OpenAPI defineOpenAP() {
        Contact contact = new Contact();
        contact.setEmail(contactEmail);
        contact.setName(contactName);

        Info info = new Info();
        info.setDescription("API de inmuebles y cliente para Inmobiliaria Casaventas");
        info.setTitle("Inmobiliaira Casaventas");
        info.setVersion(infoVersion);
        info.contact(contact);

        return new OpenAPI()
                .info(info)
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP).scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}
