package com.inmobicasaventas.gestinmo.api.documents.infrastructure.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inmobicasaventas.gestinmo.api.documents.domain.models.Document;

@Component
public class DocumentMapper {
    public List<String> toNamesList(List<Document> documents) {
        return documents.stream().map(Document::getName).toList();
    }
}
