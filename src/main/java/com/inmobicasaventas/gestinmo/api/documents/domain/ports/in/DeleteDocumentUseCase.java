package com.inmobicasaventas.gestinmo.api.documents.domain.ports.in;

import com.inmobicasaventas.gestinmo.api.documents.domain.models.Document;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public interface DeleteDocumentUseCase {
    boolean delete(Property property, Document document);
}