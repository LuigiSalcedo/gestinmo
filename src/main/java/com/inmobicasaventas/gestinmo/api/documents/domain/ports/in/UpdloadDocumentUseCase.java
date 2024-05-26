package com.inmobicasaventas.gestinmo.api.documents.domain.ports.in;

import java.io.InputStream;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public interface UpdloadDocumentUseCase {
    boolean upload(Property property, String documentName, InputStream data);
}
