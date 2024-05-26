package com.inmobicasaventas.gestinmo.api.documents.domain.ports.in;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.documents.domain.models.Document;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public interface SearchDocumentByPropertyUseCase {
    List<Document> searchByProperty(Property property);
}
